package com.ai.aso.common.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;
import com.ai.aso.common.bo.ContractBo;

public interface ContractActivateService {
	/**
	 * 审核激活申请--地市
	 * @param contractBo
	 * @param managerId
	 * @return
	 */
	public String activateApply(ContractBo contractBo, String managerId, String fileinfo);

	/**
	 * 激活审核--省
	 * @param contractBo
	 * @param managerId
	 * @return
	 */
	public String activateAudit(ContractBo contractBo, String managerId, String remark);

	/**
	 * 上传支付凭证--地市审核激活申请
	 * @param payCert
	 * @param accId
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> payCertUpload(MultipartFile payCert, String accId) throws Exception;

	/**
	 * 审核信息显示--省
	 * @param contId
	 * @param managerId
	 * @return
	 */
	public ContractBo activateAuditView(String contId, String managerId);

	/**
	 * 待激活审核合同查询--省
	 * @param contNo
	 * @param custId
	 * @param managerId
	 * @return
	 */
	public List<ContractBo> contractActivateList(String contNo, String custId, String managerId);

	/**
	 * 激活申请显示--地市
	 * @param contId
	 * @param acctId
	 * @return
	 */
	public ContractBo activateApplyView(String contId, String acctId);
	/**
	 * 小客户缴费激活--地市
	 * @param contractBo
	 * @param managerId
	 * @return
	 */
	public String  payAndActivatePersonal(ContractBo contractBo, String managerId, String fileinfo);

}
