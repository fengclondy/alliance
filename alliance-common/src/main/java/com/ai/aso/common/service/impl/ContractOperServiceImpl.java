package com.ai.aso.common.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.aso.common.param.GlobalParamSet;
import com.ai.aso.common.constants.BizConstants;
import com.ai.aso.common.db.dao.ContractOperMapper;
import com.ai.aso.common.db.dao.LoginAcctMapper;
import com.ai.aso.common.db.model.Contract;
import com.ai.aso.common.db.model.ContractOper;
import com.ai.aso.common.db.model.LoginAcct;
import com.ai.aso.common.service.ContractOperService;

@Service
public class ContractOperServiceImpl implements ContractOperService {
	
	@Autowired
	private ContractOperMapper contractOperMapper;
	@Autowired
	private LoginAcctMapper loginAcctMapper;

	@Override
	public void inputOper(Contract contract) {
		ContractOper oper = new ContractOper();
		LoginAcct acct = loginAcctMapper.selectByPrimaryKey(contract.getServiceId());
		oper.setContId(contract.getContId());
		oper.setOperatorId(Long.parseLong(contract.getServiceId()));
		oper.setOperatorName(acct.getNickname());
		oper.setOperDate(new Date());
		oper.setOperComm("合同申请");
		oper.setStepId(GlobalParamSet.getString(BizConstants.CONTRACT_OPER_STEP_APPLY));
		
		contractOperMapper.insertSelective(oper);
	}

	@Override
	public void inputAuditOper(String contId, String remark, String acctId) {
		ContractOper oper = new ContractOper();
		LoginAcct acct = loginAcctMapper.selectByPrimaryKey(acctId);
		oper.setContId(contId);
		oper.setOperatorId(Long.parseLong(acctId));
		oper.setOperatorName(acct.getNickname());
		oper.setOperDate(new Date());
		oper.setOperComm("合同录入审核通过");
		oper.setStepId(GlobalParamSet.getString(BizConstants.CONTRACT_OPER_STEP_APPLY));
		oper.setRemarks(remark);
		
		contractOperMapper.insertSelective(oper);
	}

	@Override
	public void inputAuditFailedOper(String contId, String remark, String acctId) {
		ContractOper oper = new ContractOper();
		LoginAcct acct = loginAcctMapper.selectByPrimaryKey(acctId);
		oper.setContId(contId);
		oper.setOperatorId(Long.parseLong(acctId));
		oper.setOperatorName(acct.getNickname());
		oper.setOperDate(new Date());
		oper.setOperComm("合同录入审核不通过");
		oper.setStepId(GlobalParamSet.getString(BizConstants.CONTRACT_OPER_STEP_APPLY));
		oper.setRemarks(remark);
		
		contractOperMapper.insertSelective(oper);
	}

	@Override
	public void activateApplyOper(Contract contract) {
		ContractOper oper = new ContractOper();
		LoginAcct acct = loginAcctMapper.selectByPrimaryKey(contract.getServiceId());
		oper.setContId(contract.getContId());
		oper.setOperatorId(Long.parseLong(contract.getServiceId()));
		oper.setOperatorName(acct.getNickname());
		oper.setOperDate(new Date());
		oper.setOperComm("激活申请");
		oper.setStepId(GlobalParamSet.getString(BizConstants.CONTRACT_OPER_STEP_ACTIVATE));
		
		contractOperMapper.insertSelective(oper);
		
	}

	@Override
	public void activateAuditSuccOper(String contId, String acctId,String remark) {
		ContractOper oper = new ContractOper();
		LoginAcct acct = loginAcctMapper.selectByPrimaryKey(acctId);
		oper.setContId(contId);
		oper.setOperatorId(Long.parseLong(acctId));
		oper.setOperatorName(acct.getNickname());
		oper.setOperDate(new Date());
		oper.setOperComm("合同激活审核通过");
		oper.setStepId(GlobalParamSet.getString(BizConstants.CONTRACT_OPER_STEP_ACTIVATE));
		oper.setRemarks(remark);
		contractOperMapper.insertSelective(oper);
		
	}

	@Override
	public void activateAuditFailedOper(String contId, String acctId,String remark) {
		ContractOper oper = new ContractOper();
		LoginAcct acct = loginAcctMapper.selectByPrimaryKey(acctId);
		oper.setContId(contId);
		oper.setOperatorId(Long.parseLong(acctId));
		oper.setOperatorName(acct.getNickname());
		oper.setOperDate(new Date());
		oper.setOperComm("合同激活审核不通过");
		oper.setStepId(GlobalParamSet.getString(BizConstants.CONTRACT_OPER_STEP_ACTIVATE));
		oper.setRemarks(remark);
		contractOperMapper.insertSelective(oper);
	}

	@Override
	public void renewalApplyOper(Contract contract) {
		ContractOper oper = new ContractOper();
		LoginAcct acct = loginAcctMapper.selectByPrimaryKey(contract.getServiceId());
		oper.setContId(contract.getContId());
		oper.setOperatorId(Long.parseLong(contract.getServiceId()));
		oper.setOperatorName(acct.getNickname());
		oper.setOperDate(new Date());
		oper.setOperComm("续费申请");
		oper.setStepId(GlobalParamSet.getString(BizConstants.CONTRACT_OPER_STEP_RENEWAL));
		
		contractOperMapper.insertSelective(oper);
		
	}

	@Override
	public void renewalAuditSuccOper(String contId, String acctId,String remark) {
		ContractOper oper = new ContractOper();
		LoginAcct acct = loginAcctMapper.selectByPrimaryKey(acctId);
		oper.setContId(contId);
		oper.setOperatorId(Long.parseLong(acctId));
		oper.setOperatorName(acct.getNickname());
		oper.setOperDate(new Date());
		oper.setOperComm("续费审核通过");
		oper.setStepId(GlobalParamSet.getString(BizConstants.CONTRACT_OPER_STEP_RENEWAL));
		oper.setRemarks(remark);
		contractOperMapper.insertSelective(oper);
		
	}

	@Override
	public void renewalAuditFailedOper(String contId, String acctId,String remark) {
		ContractOper oper = new ContractOper();
		LoginAcct acct = loginAcctMapper.selectByPrimaryKey(acctId);
		oper.setContId(contId);
		oper.setOperatorId(Long.parseLong(acctId));
		oper.setOperatorName(acct.getNickname());
		oper.setOperDate(new Date());
		oper.setOperComm("续费审核不通过");
		oper.setStepId(GlobalParamSet.getString(BizConstants.CONTRACT_OPER_STEP_RENEWAL));
		oper.setRemarks(remark);
		contractOperMapper.insertSelective(oper);
		
	}

	@Override
	public void contCarryOper(String contId, String acctId) {
		ContractOper oper = new ContractOper();
		LoginAcct acct = loginAcctMapper.selectByPrimaryKey(acctId);
		oper.setContId(contId);
		oper.setOperatorId(Long.parseLong(acctId));
		oper.setOperatorName(acct.getNickname());
		oper.setOperDate(new Date());
		oper.setOperComm("合同余额结转");
		oper.setStepId(GlobalParamSet.getString(BizConstants.CONTRACT_OPER_STEP_CARRY));
		contractOperMapper.insertSelective(oper);
		
	}

	@Override
	public void contColumnOper(String contId, String acctId) {
		ContractOper oper = new ContractOper();
		LoginAcct acct = loginAcctMapper.selectByPrimaryKey(acctId);
		oper.setContId(contId);
		oper.setOperatorId(Long.parseLong(acctId));
		oper.setOperatorName(acct.getNickname());
		oper.setOperDate(new Date());
		oper.setOperComm("合同列收");
		oper.setStepId(GlobalParamSet.getString(BizConstants.CONTRACT_OPER_STEP_COLUMN));
		contractOperMapper.insertSelective(oper);
		
	}

}
