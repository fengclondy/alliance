package com.ai.aso.common.fps.service.impl;/**
 * Created by DK on 2017/10/30.
 */

import com.ai.aso.common.bo.DataRecBo;
import com.ai.aso.common.constants.ResultMsg;
import com.ai.aso.common.db.dao.DataRecMapper;
import com.ai.aso.common.db.dao.FlowOrderLogMapper;
import com.ai.aso.common.db.dao.ext.DataRecExtMapper;
import com.ai.aso.common.db.model.DataRec;
import com.ai.aso.common.db.model.FlowOrderLog;
import com.ai.aso.common.fps.webService.model.FlowOrder;
import com.ai.aso.common.fps.webService.model.FlowOrderResult;
import com.ai.aso.common.fps.webService.service.FlowOrderInterface;
import com.ai.aso.common.service.DistributionService;
import com.ai.aso.common.service.RechargeMsgReciver;
import com.ai.aso.common.service.RegionService;
import com.ai.aso.common.webService.service.impl.OrderInterfaceServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;

/**
 * @author dk
 * @create 2017-10-30-9:52
 **/
@Service("fpsRechargeMsgReciver")
public class FpsRechargeMsgReciverImpl implements RechargeMsgReciver {


    @Autowired
    private RegionService regionService;

    @Autowired
    private DistributionService distributionService;

    @Autowired
    private DataRecMapper dataRecMapper;

    @Autowired
    private FlowOrderInterface flowOrderInterfaceService;
    @Autowired
    private FlowOrderLogMapper flowOrderLogMapper;

    Logger log = LoggerFactory.getLogger("FlowOrder");

    public static HashMap<String,String> regionMap;

    private synchronized HashMap<String,String> initRegionMap()
    {
        if( regionMap == null )
        {
            regionMap = regionService.loadRegionMap();
        }
        return regionMap;
    }

    @Override
    public void useCrmInterface(DataRecBo bo) {
        initRegionMap();
        //此处吊用crm接口充值
        int state_no = DistributionService.State.ST_NO_DEAL;
        int state_timeout = DistributionService.State.ST_TIMEOUT;
        bo.setBeginDate(new Date());
        if( bo.getState().intValue() == state_no )
        {
            order(bo);//充值
        }

    }

    @Override
    public void order(DataRecBo bo) {
        //查询数据库本条充值记录处理状态
        if( !checkDataRecState(bo.getRecNo()) )
        {
            //log.info("调用充值接口前校验:【"+bo.getRecNo()+"】的状态不是未处理或者库里不存在该记录" );
            return;
        }
        //将记录状态修改成处理中


        FlowOrder order = new FlowOrder();
        order.setRequest_no(bo.getRecNo());
        order.setPhone_id(bo.getUserNbr());
        order.setCrm_offer_id(bo.getOfferId());
        order.setContract_name(bo.getContId());
        order.setDiscount(bo.getDiscount().toString());

        FlowOrderLog orderLog = new FlowOrderLog();
        orderLog.setRequestNo(order.getRequest_no());
        orderLog.setRequestData(order.toString());
        orderLog.setCreateDate(new Date());
        orderLog.setPhoneId(order.getPhone_id());
        orderLog.setContId(order.getContract_name());
        orderLog.setDiscount(order.getDiscount());
        orderLog.setOfferId(order.getCrm_offer_id());

        //流量包订购接口，省接综合平台，发起客户订购请求
        FlowOrderResult rs = flowOrderInterfaceService.flowOrder(order);

        orderLog.setResultCode(rs.getResult_code());
        orderLog.setResultDate(new Date());
        if("00000".equals(rs.getResult_code())){
            orderLog.setState(ResultMsg.FPS_FLOWORDER_ORDER);//定购中
        }else{
            orderLog.setState(ResultMsg.FPS_FLOWORDER_ERROR);//定购失败
            log.error("流量包订购接口失败,合同号:"+bo.getContId()+",流水号:"+order.getRequest_no()+",错误代码:"+rs.getResult_code());
            bo.setState((short)DistributionService.State.ST_FAILD);
            bo.setBillSerial("");
            distributionService.crmFieldResult(bo);
        }
        FlowOrderLog flowOrderLog = flowOrderLogMapper.selectByPrimaryKey(orderLog.getRequestNo());
        //记录日志
        if(flowOrderLog!=null){
            flowOrderLogMapper.insertSelective(orderLog);
        }else{
            flowOrderLogMapper.updateByPrimaryKeySelective(orderLog);
        }

    }

    @Override
    public void orderNew(DataRecBo bo) {
        bo.setState((short)DistributionService.State.ST_FAILD);
        bo.setBillSerial("");
        distributionService.crmFieldResult(bo);
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

}
