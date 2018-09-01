/**
 * 
 */
package com.ai.aso.common.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.aso.common.param.GlobalParamSet;
import com.ai.aso.common.bo.CrmOutParam;
import com.ai.aso.common.bo.DataRecBo;
import com.ai.aso.common.constants.BizConstants;
import com.ai.aso.common.constants.ResultMsg;
import com.ai.aso.common.db.dao.DataRecMapper;
import com.ai.aso.common.db.dao.ext.DataRecExtMapper;
import com.ai.aso.common.db.model.CustBill;
import com.ai.aso.common.db.model.DataRec;
import com.ai.aso.common.db.model.DataRecExample;
import com.ai.aso.common.service.DistributionService;
import com.ai.aso.common.service.RechargeMsgReciver;
import com.ai.aso.common.service.RegionService;
import com.ai.aso.common.webService.service.impl.OrderInterfaceServiceImpl;
import com.alibaba.fastjson.JSONObject;

/** 
 * @ClassName: RchargeMsgReciver
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author caiwz
 * @date 2016-10-14 下午3:44:56
 *
 */
@Component
public class RchargeMsgReciverImpl implements RechargeMsgReciver {

	private static final Logger log = LoggerFactory
			.getLogger("RECHARGE_LOGFILE");
	@Autowired
	private RegionService regionService;
	
	@Autowired
	private DistributionService distributionService;
	
	@Autowired
	private OrderInterfaceServiceImpl orderInterfaceServiceImpl;
	
	@Autowired
	private DataRecMapper dataRecMapper;
	
	@Autowired
	private DataRecExtMapper dataRecExtMapper;
	
	public static HashMap<String,String> regionMap; 
	
	private synchronized HashMap<String,String> initRegionMap()
	{
		if( regionMap == null )
		{
			regionMap = regionService.loadRegionMap();
		}
		return regionMap;
	}
	/* (non-Javadoc)
	 * @see com.ai.aso.biz.service.RechargeMsgReciver#sendToCrmInterface(java.lang.Object)
	 */
	@Override
	public void useCrmInterface(DataRecBo bo) {
		// TODO Auto-generated method stub
		initRegionMap();
		//此处吊用crm接口充值
		int state_no = DistributionService.State.ST_NO_DEAL;
		int state_timeout = DistributionService.State.ST_TIMEOUT;
		bo.setBeginDate(new Date());
		if( bo.getState().intValue() == state_no )
		{
			order(bo);//充值
		}
		else if( bo.getState().intValue() == state_timeout )
		{
			query(bo);
		}
	}

	private boolean checkDataRecState(String no)
	{
		DataRec dr = dataRecMapper.selectByPrimaryKey(no);
		
		if( dr == null )
			return false;
		//状态：0 未处理；1 处理中；2 充值成功；3 超时待确认；-1 充值失败；
		int state = DistributionService.State.ST_NO_DEAL;
		if (dr.getState().intValue() != state) 
		{
			return false;
		}
		return true;
	}
	@Override
	public void order(DataRecBo bo){
		//查询数据库本条充值记录处理状态
		if( !checkDataRecState(bo.getRecNo()) )
		{
			//log.info("调用充值接口前校验:【"+bo.getRecNo()+"】的状态不是未处理或者库里不存在该记录" );
			return;
		}
		//将记录状态修改成处理中
		distributionService.updateDataRecState(bo.getRecNo(), DistributionService.State.ST_DEALING);
		
		//以上构造crm接口入参
		JSONObject crmJson = orderInterfaceServiceImpl.orderSprom(bo.getRecNo(), bo.getUserNbr(), bo.getOfferId());
		//此处调用crm接口
		CrmOutParam out = JSONObject.toJavaObject(crmJson, CrmOutParam.class);
		//以下解析crm接口出参
		dealResult(bo,out);
	}
	
	@Override
	public void orderNew(DataRecBo bo){
		bo.setState((short)DistributionService.State.ST_FAILD);
		bo.setBillSerial("");
		distributionService.crmFieldResult(bo);
	}
	private void dealResult(DataRecBo bo,CrmOutParam out)
	{
		bo.setServId(out.getProvId());
		String areaCode = "";
		if( out.getAreaCode() != null && !"".equals(out.getAreaCode()) )
		{
			areaCode = regionMap.get(out.getAreaCode())==null?"0":regionMap.get(out.getAreaCode());
			bo.setCostRegion(Integer.parseInt(areaCode));
		}
		bo.setEndDate(new Date());
		bo.setResultMesg(out.getResultMsg());
		bo.setResultCode(out.getResultCode());
		bo.setErrMesg(out.getErrmsg());
		if( "0".equals(out.getResult()))//成功
		{//状态：0 未处理；1 处理中；2 充值成功；3 超时待确认；-1 充值失败；
			bo.setState((short)DistributionService.State.ST_SUCCESS);
			bo.setBillSerial("");
			distributionService.crmSuccResult(bo);
		}
		else if( "1".equals(out.getResult()) )
		{
			bo.setState((short)DistributionService.State.ST_FAILD);
			bo.setBillSerial("");
			distributionService.crmFieldResult(bo);
		}
		else if( "2".equals(out.getResult()) )
		{
			bo.setState((short)DistributionService.State.ST_TIMEOUT);
			bo.setBillSerial("");
			distributionService.crmSuccResult(bo);
		}
	}
	
	private void query(DataRecBo bo) {
		// TODO Auto-generated method stub
		int f = dataRecExtMapper.updateVer(bo.getVer(), bo.getRecNo());
		if( f > 0 )
		{
			bo.setVer(bo.getVer()+1);
			JSONObject crmJson = orderInterfaceServiceImpl.queryOrderResult(bo.getRecNo(), bo.getUserNbr());
			CrmOutParam out = JSONObject.toJavaObject(crmJson, CrmOutParam.class);
			dealQueryResult(bo,out);
		}
		
	}
	
	private void dealQueryResult(DataRecBo bo,CrmOutParam out)
	{
		bo.setServId(out.getProvId());
		String areaCode = "";
		if( out.getAreaCode() != null && !"".equals(out.getAreaCode()) )
		{
			areaCode = regionMap.get(out.getAreaCode())==null?"0":regionMap.get(out.getAreaCode());
			bo.setCostRegion(Integer.parseInt(areaCode));
		}
		bo.setEndDate(new Date());
		bo.setResultMesg(out.getResultMsg());
		bo.setResultCode(out.getResultCode());
		bo.setErrMesg(out.getErrmsg());
		if( "0".equals(out.getResult()))//成功
		{//状态：0 未处理；1 处理中；2 充值成功；3 超时待确认；-1 充值失败；
			bo.setState((short)DistributionService.State.ST_SUCCESS);
			bo.setBillSerial("");
			distributionService.crmSuccResult(bo);
		}
		else if( "1".equals(out.getResult()) )
		{
			bo.setState((short)DistributionService.State.ST_FAILD);
			bo.setBillSerial("");
			/*if( out.getResultCode().equals(ResultMsg.OPER_MSGCODE_URL_FAIL) )
			{//查询接口如果连接超时，那么只更新ver,state依然是超时待确认
				bo.setState((short)DistributionService.State.ST_TIMEOUT);
				distributionService.crmSuccResult(bo);
				return;
			}*/
			distributionService.crmFieldResult(bo);
		}
		else if( "2".equals(out.getResult()) )
		{//查询接口查询结果超时，那么只更新ver,state依然是超时待确认
			bo.setState((short)DistributionService.State.ST_TIMEOUT);
			bo.setBillSerial("");
			distributionService.crmSuccResult(bo);
		}
	}
	
	

	public void interposeResult()
	{
		//查询指定时间未处理的记录
		DataRecExample example = new DataRecExample();
		example.createCriteria().andStateIn(null);
		List<DataRec> dataRecs=dataRecMapper.selectByExample(example);
		int UNIT=GlobalParamSet.getInteger(BizConstants.ORDER_MEDDLE_COMFIRE_TIME_UNIT);
		if(null!=dataRecs&&dataRecs.size()>0){
			List<DataRecBo> boList = DataRecBo.convertList(dataRecs);
			for (DataRecBo bo : boList) {	
				if((new Date().getTime()-bo.getCreateDate().getTime())/UNIT>=GlobalParamSet.getLong(BizConstants.ORDER_MEDDLE_COMFIRE_TIME)){	
					bo.setEndDate(new Date());
					bo.setResultMesg(ResultMsg.MSG_SYSTEM_ERR);
					bo.setResultCode(ResultMsg.OPER_MSGCODE_RESPONSE_FAIL);
					bo.setErrMesg(ResultMsg.MSG_SYSTEM_ERR);
					bo.setState((short)DistributionService.State.ST_FAILD);
					bo.setBillSerial("");
					distributionService.crmFieldResult(bo);
				}
				
			}
		}
			
	
	}
	
}
