package com.ai.aso.common.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.aso.common.param.GlobalParamSet;
import com.ai.aso.common.constants.BizConstants;
import com.ai.aso.common.db.dao.EnablerApplyMapper;
import com.ai.aso.common.db.dao.EnablerHostMapper;
import com.ai.aso.common.db.dao.ext.EnablerHostExtMapper;
import com.ai.aso.common.db.model.Cust;
import com.ai.aso.common.db.model.EnablerApply;
import com.ai.aso.common.db.model.EnablerApplyExample;
import com.ai.aso.common.db.model.EnablerHost;
import com.ai.aso.common.db.model.EnablerHostExample;
import com.ai.aso.common.service.CustAuditService;
import com.ai.aso.common.service.CustService;
import com.ai.aso.common.service.LoginAcctService;

@Service
public class CustAuditServiceImpl implements CustAuditService {
	
	private static final Logger log = LoggerFactory.getLogger(CustAuditServiceImpl.class);

	@Autowired
	private EnablerApplyMapper enablerApplyMapper;
	@Autowired
	private EnablerHostMapper enablerHostMapper;
	@Autowired
	private EnablerHostExtMapper hostExtMapper;
	@Autowired
	private LoginAcctService loginAcctService;
	@Autowired
	private CustService custService;
	
	@Override
	@Transactional
	public void conserveIP(String custId, String hostIP) {
		log.debug("======================提交开放接口申请============================");
		//1. 根据custId，查询当前客户的接口状态，允许使用此功能的状态为：a. 未申请（enablerApplyState 为null），b.审核通过，c.审核不通过
		//查询enabler表中是否存在相同的cust_Id
		EnablerApplyExample applyExample = new EnablerApplyExample();
		applyExample.createCriteria().andCustIdEqualTo(custId);
		List<EnablerApply> enablerExamples = enablerApplyMapper.selectByExample(applyExample);
		log.debug("根据custId["+custId+"] 查找开放接口表信息");
		
		//2. 允许申请，执行：
		//a.已存在申请记录，更新记录状态为待审核，删除原绑定IP列表，删除原有随机密码账户，重新申请账户。
		//b. 未存在申请记录，新增状态位待审核的记录，插入绑定IP表，新增随机密码账户
		

		Long applyId = null;
		if(enablerExamples.size()>0){
			log.debug("根据custId["+custId+"] 查找到开放接口：" + enablerExamples.get(0).getApplyId());
			EnablerApply enablerApply = enablerExamples.get(0);
			enablerApply.setApplyDate(new Date());
			applyId = enablerApply.getApplyId();
			int oldState = enablerApply.getState();
			
			enablerApply.setState(GlobalParamSet.getInteger(BizConstants.ENABLER_STATE_CHECK));
			
			log.debug("提交前状态为：" + oldState);
			//申请成功的重新申请的
			if(GlobalParamSet.getInteger(BizConstants.ENABLER_STATE_ADOPT) == oldState) {
				loginAcctService.removeCustEnablerApply(enablerApply.getAcctId());
				enablerApply.setAcctId(null);
				enablerApplyMapper.updateByPrimaryKey(enablerApply);
			}else if(GlobalParamSet.getInteger(BizConstants.ENABLER_STATE_FAIL) == oldState){
				enablerApplyMapper.updateByPrimaryKey(enablerApply);
			}
			
			EnablerHostExample hostExample = new EnablerHostExample();
			hostExample.createCriteria().andApplyIdEqualTo(applyId);
			enablerHostMapper.deleteByExample(hostExample);
		} else {
			log.debug("提交前为null，即新增" );
			Cust cust = custService.findCustByCustId(custId);
			EnablerApply apply = new EnablerApply();
			apply.setCustId(custId);
			apply.setCustName(cust.getCustName());
			apply.setApplyDate(new Date());
			//绑定IP时设置所有的状态都为待审核
			apply.setState(GlobalParamSet.getInteger(BizConstants.ENABLER_STATE_CHECK));
			//enablerApply表中返回主键
			enablerApplyMapper.insert(apply);
			applyId = apply.getApplyId();
		}
		
		log.debug("插入ip：" + hostIP);
		insertHostIP(applyId, hostIP);
			
	}
	
	//tc_enabler_host 表中循环插入IP的方法
	private void insertHostIP(long applyId, String hostIP){
		String [] host = hostIP.split(",");
		List<EnablerHost> list = new ArrayList<>();
		
		for (String string : host) {
			EnablerHost enablerhost = new EnablerHost();
			enablerhost.setApplyId(applyId);
			enablerhost.setHostIp(string);
			list.add(enablerhost);
		}
		
		hostExtMapper.insertHostIP(list);
	 }

}
