package com.ai.aso.common.service;

import com.ai.aso.common.db.model.Contract;

public interface ContractOperService {

	/**
	 * 合同录入操作记录
	 * @param contract
	 */
	void inputOper(Contract contract);
	
	/**
	 * 合同录入审核通过操作记录
	 * @param contId
	 * @param acctId
	 */
	void inputAuditOper(String contId, String remark, String acctId);
	
	/**
	 * 合同录入审核不通过操作记录
	 * @param contId
	 * @param acctId
	 */
	void inputAuditFailedOper(String contId, String remark, String acctId);

	/**
	 *激活审核申请操作记录
	 * @param contract
	 */
	void activateApplyOper(Contract contract);
	
	/**
	 * 激活审核成功操作记录
	 * @param contId
	 * @param acctId
	 */
	void activateAuditSuccOper(String contId, String acctId, String remark);
	/**
	 * 激活审核失败操作记录
	 * @param contId
	 * @param acctId
	 */
	void activateAuditFailedOper(String contId, String acctId, String remark);
	
	
	
	/**
	 *续费申请操作记录
	 * @param contract
	 */
	void renewalApplyOper(Contract contract);
	
	/**
	 * 续费审核成功操作记录
	 * @param contId
	 * @param acctId
	 */
	void renewalAuditSuccOper(String contId, String acctId, String remark);
	/**
	 * 续费审核失败操作记录
	 * @param contId
	 * @param acctId
	 */
	void renewalAuditFailedOper(String contId, String acctId, String remark);
	/**
	 * 合同结转记录
	 * @param contract
	 */
	void contCarryOper(String contId, String acctId);
	/**
	 * 合同列收
	 * @param contract
	 */
	void contColumnOper(String contId, String acctId);
}
