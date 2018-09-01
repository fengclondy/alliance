package com.ai.aso.common.service;

import com.ai.aso.common.bo.ContractBo;
import com.ai.aso.common.db.model.Contract;

public interface ContractService {

	/**
	 * 新增合同
	 * 
	 * @param contract
	 * @param contEffDate
	 */
	void addContract(Contract contract, int contEffDate);

	/**
	 * 查找最晚到期的合同
	 * 
	 * @param custId
	 * @return
	 */
	Contract findLastContractByCustId(String custId);

	/**
	 * 审核
	 * 
	 * @param contId
	 */
	void auditCont(String contId);

	/**
	 * 审核失败
	 * 
	 * @param contId
	 */
	void auditFailedCont(String contId);

	/**
	 * 续费申请显示--地市
	 * 
	 * @param contractBo
	 * @param managerId
	 * @return
	 */
	ContractBo renewalApplyView(String contId, String managerId);

	/**
	 * 续费申请提交--地市
	 * 
	 * @param contractVo
	 * @param acctId
	 * @param payCert
	 * @return
	 */
	String renewalApply(ContractBo contractBo, String acctId, String payCert, Long payFee);

	/**
	 * 续费审核--省级
	 * 
	 * @param contractBo
	 * @param managerId
	 * @return
	 */
	String renewalAudit(ContractBo contractBo, String managerId, String remark);
	
	/**
	 * 新增小客户合同
	 * 
	 * @param contract
	 * @param contEffDate
	 */
	void addPersonalContract(Contract contract, int contEffDate);
	/**
	 * 小客户续费--地市
	 * 
	 * @param contractVo
	 * @param acctId
	 * @param payCert
	 * @return
	 */
	String renewalPersonalContract(ContractBo contractBo, String acctId, String payCert, Long payFee);

}
