package com.ai.aso.common.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ai.aso.common.db.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ai.aso.base.exception.BusinessException;
import com.ai.aso.base.exception.ExInfoEnum;
import com.ai.aso.common.param.GlobalParamSet;
import com.ai.aso.base.utils.StringUtil;
import com.ai.aso.common.bo.ContractBo;
import com.ai.aso.common.bo.ContractBookBo;
import com.ai.aso.common.constants.BizConstants;
import com.ai.aso.common.db.dao.ContractBookMapper;
import com.ai.aso.common.db.dao.ContractMapper;
import com.ai.aso.common.db.dao.PaymentMapper;
import com.ai.aso.common.db.model.Contract;
import com.ai.aso.common.db.model.ContractBook;
import com.ai.aso.common.db.model.ContractBookExample;
import com.ai.aso.common.db.model.ContractExample.Criteria;
import com.ai.aso.common.db.model.DataBooka;
import com.ai.aso.common.db.model.ContractExample;
import com.ai.aso.common.db.model.Payment;
import com.ai.aso.common.exception.NoAccessException;
import com.ai.aso.common.service.BookManagerService;
import com.ai.aso.common.service.ContractActivateService;
import com.ai.aso.common.service.ContractOperService;
import com.ai.aso.common.service.UserService;
import com.ai.aso.common.utils.FileOperateUtil;
import com.ai.aso.common.sequence.SequenceFactory;

@Service
public class ContractActivateServiceImpl implements ContractActivateService {
	@Autowired
	private ContractMapper contractMapper;
	@Autowired
	private UserService userService;
	@Autowired
	private PaymentMapper paymentMapper;
	@Autowired
	private SequenceFactory sequenceFactory;
	@Autowired
	private ContractBookMapper contractBookMapper;
	@Autowired
	private BookManagerService bookManagerService;
	@Autowired
	private ContractOperService contractOperService;

	@Transactional
	@Override
	public String activateApply(ContractBo contractBo, String managerId, String fileinfo) {

		// 判断是不是属于地市级管理员所属的客户合同
		User bo = userService.findUserByAcctId(managerId);
		// 地市级查询校验
		String regionId = bo.getRegionId();
		// 查询参数
		Contract queryContract = contractBo.toContractt();
		if (null != queryContract && StringUtil.isNotEmpty(queryContract.getContId())) {
			Contract contract = contractMapper.selectByPrimaryKey(queryContract.getContId());

			if (StringUtil.isNotEmpty(regionId)
					&& (GlobalParamSet.getString(BizConstants.PROVINCE_ADMIN_REGION) != regionId)
					&& (Integer.parseInt(regionId) == contract.getRegionId())) {
				// 判断合同是否失效
				if (GlobalParamSet.getInteger(BizConstants.CONTRACT_STATE_DISABLED) == contract.getState()
						&& (GlobalParamSet.getInteger(BizConstants.CONTRACT_SUB_STATE_AUDIT) == contract.getSubState()
								|| GlobalParamSet.getInteger(BizConstants.CONTRACT_SUB_STATE_LIVEFAILED) == contract
										.getSubState())) {
					// CONTRACT.SUB.STATE.WAITAUDITLIVE待激活审核
					contract.setSubState(GlobalParamSet.getInteger(BizConstants.CONTRACT_SUB_STATE_WAITAUDITLIVE));
					// 支付金额
					//contract.setPayedFee(queryContract.getPayedFee());
					//本次缴费
					contract.setExt1(String.valueOf(queryContract.getPayedFee()));
					// 支付流水号
					String payMentId = sequenceFactory.next(BizConstants.SEQ_KEY_PAYMENT);
					contract.setPaymentId(payMentId);
					// 付费类型
					contract.setPayType(GlobalParamSet.getShort(BizConstants.PAY_TYPE_PREPAY));

					// 生成支付流水
					Payment payment = new Payment();
					payment.setAmount(queryContract.getPayedFee());
					payment.setApplyDate(new Date());
					payment.setCostType(GlobalParamSet.getInteger(BizConstants.COST_TYPE_ACTIVATE));
					payment.setCustId(contract.getCustId());
					payment.setObjectId(queryContract.getContId());
					payment.setObjectType(GlobalParamSet.getInteger(BizConstants.PAY_OBJECT_TYPE_ADVANCES));
					payment.setOperator(managerId);
					// 支付凭证
					payment.setPayCert(fileinfo);
					payment.setPaymentId(payMentId);
					payment.setPayState(GlobalParamSet.getInteger(BizConstants.PAY_STATE_PAY_CONFIREMED));
					payment.setPayMode(GlobalParamSet.getInteger(BizConstants.PAY_MODE_BYBANK));

					contractMapper.updateByPrimaryKeySelective(contract);
					paymentMapper.insertSelective(payment);
					contractOperService.activateApplyOper(contract);
					return contract.getContId();
				} else {
					// 合同状态异常
					throw new BusinessException(ExInfoEnum.VALIDATE_CONT_STATE_EXCPTION);
				}
			} else {
				// 没有操作权限
				throw new NoAccessException();
			}
		} else {
			// 合同异常
			throw new BusinessException(ExInfoEnum.VALIDATE_CONT_NOT_EXSIT);
		}
	}

	@Override
	@Transactional
	public String activateAudit(ContractBo contractBo, String managerId, String remark) {
		// 判断是不是省级管理员
		User bo = userService.findUserByAcctId(managerId);
		// 地市级查询校验
		String regionId = bo.getRegionId();
		Contract queryContract = contractBo.toContractt();
		if (null != queryContract && StringUtil.isNotEmpty(queryContract.getContId())) {
			Contract contract = contractMapper.selectByPrimaryKey(queryContract.getContId());
			if (StringUtil.isNotEmpty(regionId)
					&&( (Integer.parseInt(regionId) == contract.getRegionId())||GlobalParamSet.getString(BizConstants.PROVINCE_ADMIN_REGION) .equalsIgnoreCase(regionId) )) {

				// 判断合同是否失效
				if ((GlobalParamSet.getInteger(BizConstants.CONTRACT_STATE_DISABLED) == contract.getState())
						&& (GlobalParamSet.getInteger(BizConstants.CONTRACT_SUB_STATE_WAITAUDITLIVE) == contract
								.getSubState())) {
					// 320 激活审核通过；330 激活审核不通过；
					if (GlobalParamSet.getInteger(BizConstants.CONTRACT_SUB_STATE_LIVESUC) == queryContract
							.getSubState()) {
						contract.setState(GlobalParamSet.getInteger(BizConstants.CONTRACT_STATE_ENABLED));
						contract.setSubState(queryContract.getSubState());
						//插入累计缴费
						contract.setPayedFee(Long.valueOf(contract.getExt1()));
						// 账本操作
						ContractBookExample example = new ContractBookExample();
						example.createCriteria().andContIdEqualTo(queryContract.getContId());
						List<ContractBook> contractBooks = contractBookMapper.selectByExample(example);
						if (null != contractBooks) {
							for (ContractBook contractBook : contractBooks) {
								// 100 保证金账本；200 支付账本；300 透支账本
								ContractBookBo bookBo = new ContractBookBo();
								bookBo.setContractBook(contractBook);

								if (GlobalParamSet.getShort(BizConstants.CONTRACT_BOOK_TYPE_PAYMENT) == contractBook
										.getBookType()) {
									// 支付金额入支付账本
									// 扣除保证金
									Long amount = contract.getPayedFee() - contract.getDeposit();
									bookManagerService.paymentBookIncome(amount, queryContract.getContId());
								}
								if (GlobalParamSet.getShort(BizConstants.CONTRACT_BOOK_TYPE_DEPOSIT) == contractBook
										.getBookType()) {
									// 保证金增加
									bookManagerService.depositBookIncome(contract.getDeposit(),
											queryContract.getContId());
								}

							}

							// 支付流水状态修改
							Payment payment = paymentMapper.selectByPrimaryKey(contract.getPaymentId());
							payment.setPayState(GlobalParamSet.getInteger(BizConstants.PAY_STATE_PAY_SUCC));
							payment.setPayDate(new Date());
							payment.setAuditor(managerId);
							paymentMapper.updateByPrimaryKeySelective(payment);
							bookManagerService.addDataBook(contract);
							contractOperService.activateAuditSuccOper(queryContract.getContId(), managerId, remark);
						} else {
							// 合同账本异常
							throw new BusinessException(ExInfoEnum.VALIDATE_CONTBOOK_NOT_EXSIT);
						}
					}
					if (GlobalParamSet.getInteger(BizConstants.CONTRACT_SUB_STATE_LIVEFAILED) == queryContract
							.getSubState()) {
						// 支付流水状态修改
						Payment payment = paymentMapper.selectByPrimaryKey(contract.getPaymentId());
						payment.setPayState(GlobalParamSet.getInteger(BizConstants.PAY_STATE_PAY_CLOSED));
						payment.setPayDate(new Date());
						payment.setAuditor(managerId);
						paymentMapper.updateByPrimaryKeySelective(payment);
						contract.setSubState(queryContract.getSubState());
						contractOperService.activateAuditFailedOper(queryContract.getContId(), managerId, remark);
					}

					contractMapper.updateByPrimaryKeySelective(contract);
					return contract.getContId();
				} else {
					// 合同状态异常
					throw new BusinessException(ExInfoEnum.VALIDATE_CONT_STATE_EXCPTION);
				}
			} else {
				// 没有操作权限
				throw new NoAccessException();
			}
		} else {

			// 合同异常
			throw new BusinessException(ExInfoEnum.VALIDATE_CONT_NOT_EXSIT);
		}
	}

	@Override
	public Map<String, Object> payCertUpload(MultipartFile payCert, String accId) throws Exception {
		String fileName = FileOperateUtil.uploadPayCert(payCert, accId);
		String filePath = GlobalParamSet.getString(BizConstants.FILE_UPLOAD_PAYMENT_PATH) + fileName;
		Map<String, Object> fileinfo = new HashMap<String, Object>();
		fileinfo.put("orfilename", payCert.getOriginalFilename());
		fileinfo.put("filename", fileName);
		fileinfo.put("filepath", filePath);
		fileinfo.put("userId", accId);

		return fileinfo;
	}

	@Override
	public ContractBo activateAuditView(String contId, String managerId) {
		// 管理员权限--省级
		User bo = userService.findUserByAcctId(managerId);
		// 地市级查询校验
		String regionId = bo.getRegionId();
		Contract contract = contractMapper.selectByPrimaryKey(contId);
		if (Integer.parseInt(regionId) == contract.getRegionId()||GlobalParamSet.getString(BizConstants.PROVINCE_ADMIN_REGION).equals(regionId)) {
			ContractBo contractbo = ContractBo.fromContract(contract);
			return contractbo;
		} else {
			throw new NoAccessException();
		}
	}

	@Override
	public List<ContractBo> contractActivateList(String contNo, String custId, String managerId) {
		ContractExample example = new ContractExample();
		// 管理员权限--省级
		User user = userService.findUserByAcctId(managerId);
		// 省级校验
		String regionId = user.getRegionId();
		if (StringUtil.isNotEmpty(regionId)) {
			Criteria criteria = example.createCriteria();
			if (StringUtil.isNotEmpty(contNo)) {
				criteria.andContNoEqualTo(contNo);
			}
			if (StringUtil.isNotEmpty(custId)) {
				criteria.andCustIdEqualTo(custId);
			}
			criteria.andSubStateNotEqualTo(GlobalParamSet.getInteger(BizConstants.CONTRACT_STATE_DISABLED));
			criteria.andSubStateEqualTo(GlobalParamSet.getInteger(BizConstants.CONTRACT_SUB_STATE_WAITAUDITLIVE));
			criteria.andRegionIdEqualTo(Integer.parseInt(regionId));
			List<Contract> list = contractMapper.selectByExample(example);
			List<ContractBo> boList = ContractBo.fromContractAndContractItems(list, null);
			return boList;

		} else {

			throw new NoAccessException();
		}
	}

	@Override
	public ContractBo activateApplyView(String contId, String acctId) {
		// 管理员权限--地市级
		User user = userService.findUserByAcctId(acctId);
		// 地市级查询校验
		String regionId = user.getRegionId();

		Contract contract = contractMapper.selectByPrimaryKey(contId);
		if ((StringUtil.isNotEmpty(regionId))
				&& (GlobalParamSet.getString(BizConstants.PROVINCE_ADMIN_REGION) != regionId)
				&& (Integer.parseInt(regionId) == contract.getRegionId())) {

			ContractBo contractbo = ContractBo.fromContract(contract);
			return contractbo;
		} else {
			throw new NoAccessException();
		}

	}

	@Override
	public String payAndActivatePersonal(ContractBo contractBo, String managerId, String fileinfo) {
		// 判断是不是属于地市级管理员所属的客户合同
		User bo = userService.findUserByAcctId(managerId);
		// 地市级查询校验
		String regionId = bo.getRegionId();
		// 查询参数
		Contract queryContract = contractBo.toContractt();
		if (null != queryContract && StringUtil.isNotEmpty(queryContract.getContId())) {
			Contract contract = contractMapper.selectByPrimaryKey(queryContract.getContId());

			if (StringUtil.isNotEmpty(regionId)
					&& (GlobalParamSet.getString(BizConstants.PROVINCE_ADMIN_REGION) != regionId)
					&& (Integer.parseInt(regionId) == contract.getRegionId())) {
				// 判断合同是否失效是否是小客户（条件待加入）
				if (GlobalParamSet.getInteger(BizConstants.CONTRACT_STATE_DISABLED) == contract.getState()
						&& (GlobalParamSet.getInteger(BizConstants.CONTRACT_SUB_STATE_AUDIT) == contract.getSubState()
								|| GlobalParamSet.getInteger(BizConstants.CONTRACT_SUB_STATE_LIVEFAILED) == contract
										.getSubState())) {
					contract.setSubState(GlobalParamSet.getInteger(BizConstants.CONTRACT_SUB_STATE_LIVESUC));
					contract.setState(GlobalParamSet.getInteger(BizConstants.CONTRACT_STATE_ENABLED));
					// 支付金额
					contract.setPayedFee(queryContract.getPayedFee());
					// 支付流水号
					String payMentId = sequenceFactory.next(BizConstants.SEQ_KEY_PAYMENT);
					contract.setPaymentId(payMentId);
					// 付费类型
					contract.setPayType(GlobalParamSet.getShort(BizConstants.PAY_TYPE_PREPAY));

					// 生成支付流水
					Payment payment = new Payment();
					payment.setAmount(queryContract.getPayedFee());
					payment.setApplyDate(new Date());
					payment.setCostType(GlobalParamSet.getInteger(BizConstants.COST_TYPE_ACTIVATE));
					payment.setCustId(contract.getCustId());
					payment.setObjectId(queryContract.getContId());
					payment.setObjectType(GlobalParamSet.getInteger(BizConstants.PAY_OBJECT_TYPE_ADVANCES));
					payment.setOperator(managerId);
					// 支付凭证
					payment.setPayCert(fileinfo);
					payment.setPaymentId(payMentId);
					payment.setPayState(GlobalParamSet.getInteger(BizConstants.PAY_STATE_PAY_SUCC));
					payment.setPayMode(GlobalParamSet.getInteger(BizConstants.PAY_MODE_BYBANK));
					contractMapper.updateByPrimaryKeySelective(contract);
					paymentMapper.insertSelective(payment);
					bookManagerService.addDataBook(contract);
					contractOperService.activateApplyOper(contract);
					return contract.getContId();
				} else {
					// 合同状态异常
					throw new BusinessException(ExInfoEnum.VALIDATE_CONT_STATE_EXCPTION);
				}
			} else {
				// 没有操作权限
				throw new NoAccessException();
			}
		} else {
			// 合同异常
			throw new BusinessException(ExInfoEnum.VALIDATE_CONT_NOT_EXSIT);
		}
	}
}
