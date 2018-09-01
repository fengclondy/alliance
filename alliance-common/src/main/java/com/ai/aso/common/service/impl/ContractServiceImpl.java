package com.ai.aso.common.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ai.aso.base.exception.BusinessException;
import com.ai.aso.base.exception.ExInfoEnum;
import com.ai.aso.common.param.GlobalParamSet;
import com.ai.aso.base.utils.StringUtil;
import com.ai.aso.common.bo.ContractBo;
import com.ai.aso.common.bo.ContractBookBo;
import com.ai.aso.common.component.BookManagerComp;
import com.ai.aso.common.constants.BizConstants;
import com.ai.aso.common.db.dao.ContractBookMapper;
import com.ai.aso.common.db.dao.ContractMapper;
import com.ai.aso.common.db.dao.PaymentMapper;
import com.ai.aso.common.db.model.Contract;
import com.ai.aso.common.db.model.ContractBook;
import com.ai.aso.common.db.model.ContractBookExample;
import com.ai.aso.common.db.model.ContractBookExample.Criteria;
import com.ai.aso.common.db.model.ContractExample;
import com.ai.aso.common.db.model.Cust;
import com.ai.aso.common.db.model.Payment;
import com.ai.aso.common.db.model.User;
import com.ai.aso.common.exception.BizExInfoEnum;
import com.ai.aso.common.exception.NoAccessException;
import com.ai.aso.common.service.BookManagerService;
import com.ai.aso.common.service.ContractOperService;
import com.ai.aso.common.service.ContractService;
import com.ai.aso.common.service.CustService;
import com.ai.aso.common.service.GoodsService;
import com.ai.aso.common.service.UserService;
import com.ai.aso.common.utils.DateTimeUtil;
import com.ai.aso.common.sequence.SequenceFactory;

@Service
public class ContractServiceImpl implements ContractService {

	@Autowired
	private ContractMapper contractMapper;
	@Autowired
	private SequenceFactory sequenceFactory;
	@Autowired
	private PaymentMapper paymentMapper;
	@Autowired
	private CustService custService;
	@Autowired
	private UserService userService;
	@Autowired
	private ContractOperService contractOperService;
	@Autowired
	private BookManagerComp bookManagerComp;
	@Autowired
	private BookManagerService bookManagerService;
	@Autowired
	private ContractBookMapper contractBookMapper;
	@Autowired
	private GoodsService goodsService;
	@Override
	public void addContract(Contract contract, int contEffDate) {
		//新增校验： 检查该客户的所有待审核合同，若存在，则无法提交新合同
		checkWaitAuditCont(contract.getCustId());
		//新增校验：合同所在地
		custService.checkCustRegion(contract.getCustId(), String.valueOf(contract.getRegionId()));
		// 步骤1：新增合同
		// 初始化部分默认字段
		// 1. 业务类型： 流量分销
		contract.setBusiType(GlobalParamSet.getString(BizConstants.FLOW_BUSI_TYPE_HN));
		// 2. ID：9位+3位随机码
		contract.setContId(sequenceFactory.next(BizConstants.SEQUENCENAME_CONTRACT));
		// 3. 支付方式：预付费
		contract.setPayType(GlobalParamSet.getShort(BizConstants.ORDER_PREPAY));
		// 4. 创建日期
		contract.setCreateDate(new Date());

		// 5. 设置当前客户名称
		Cust cust = custService.findCustByCustId(contract.getCustId());
		contract.setCustName(cust.getCustName());

		// 6. 获取最晚到期的合同信息，并设置当前合同最早生效日期为最晚到期时间+1天，若没有已生效的合同，则生效日期为当天
		Contract last = findLastContractByCustId(contract.getCustId());
		//判断当前时间是不是在续签合同时间
		contract.setEffDate(last == null||last.getExpDate().getTime()<new Date().getTime() ? new Date() : last.getExpDate());

		// 7. 到期时间
		contract.setExpDate(DateTimeUtil.addDate(contract.getEffDate(), contEffDate, Calendar.MONTH));

		// 8. 设置初始化状态
		contract.setState(GlobalParamSet.getInteger(BizConstants.CONTRACT_STATE_DISABLED));
		contract.setSubState(GlobalParamSet.getInteger(BizConstants.CONTRACT_SUB_STATE_WAITAUDIT));
		contractMapper.insertSelective(contract);

		// 步骤2： 新增合同操作流水
		contractOperService.inputOper(contract);
	}

	public Contract findLastContractByCustId(String custId) {

		ContractExample example = new ContractExample();
		example.createCriteria().andCustIdEqualTo(custId)
				.andStateEqualTo(GlobalParamSet.getInteger(BizConstants.CONTRACT_STATE_ENABLED));
		example.setOrderByClause("Exp_Date desc");

		List<Contract> contList = contractMapper.selectByExample(example);

		if (null != contList && contList.size() > 0) {
			return contList.get(0);
		} else {
			return null;
		}
	}

	@Override
	public void auditCont(String contId) {
		Contract contract = new Contract();
		contract.setContId(contId);
		contract.setSubState(GlobalParamSet.getInteger(BizConstants.CONTRACT_SUB_STATE_AUDIT));

		contractMapper.updateByPrimaryKeySelective(contract);
	}

	@Override
	public void auditFailedCont(String contId) {
		Contract contract = new Contract();
		contract.setContId(contId);
		contract.setState(GlobalParamSet.getInteger(BizConstants.CONTRACT_STATE_CLOSED));
		contract.setSubState(GlobalParamSet.getInteger(BizConstants.CONTRACT_SUB_STATE_FAILED));

		contractMapper.updateByPrimaryKeySelective(contract);
	}

	@Override
	@Transactional
	public String renewalAudit(ContractBo contractBo, String managerId, String remark) {

		// 判断是不是省级管理员
		User bo = userService.findUserByAcctId(managerId);
		String regionId = bo.getRegionId();
		Contract queryContract = contractBo.toContractt();
		if (null != queryContract && StringUtil.isNotEmpty(queryContract.getContId())) {
			Contract contract = contractMapper.selectByPrimaryKey(queryContract.getContId());
			if(null !=contract&&StringUtil.isNotEmpty(contract.getContId())){
			if (StringUtil.isNotEmpty(regionId)&& ((Integer.parseInt(regionId) == contract.getRegionId())||GlobalParamSet.getString(BizConstants.PROVINCE_ADMIN_REGION).equals(regionId))) {

				// 判断合同是否失效
				if ((GlobalParamSet.getInteger(BizConstants.CONTRACT_STATE_ENABLED) == contract.getState())
						&& (GlobalParamSet.getInteger(BizConstants.CONTRACT_SUB_STATE_WAITAUDITRENEWAL) == contract
								.getSubState())) {
					// 410 续费审核通过；420 续费审核不通过；
					if (GlobalParamSet.getInteger(BizConstants.CONTRACT_SUB_STATE_RENEWALSUC) == queryContract
							.getSubState()) {
						// 状态
						contract.setSubState(queryContract.getSubState());
						//累计支付金额
						contract.setPayedFee(contract.getPayedFee()+Long.valueOf(contract.getExt1()));
						// 信用账本
						ContractBookExample example = new ContractBookExample();
						Criteria criteria = example.createCriteria();
						criteria.andContIdEqualTo(contract.getContId());
						criteria.andBookTypeEqualTo(GlobalParamSet.getShort(BizConstants.CONTRACT_BOOK_TYPE_CREDIT));
						List<ContractBook> credictBooks = contractBookMapper.selectByExample(example);
						//支付账本
						ContractBookExample payexample = new ContractBookExample();
						Criteria paycriteria = payexample.createCriteria();
						paycriteria.andContIdEqualTo(contract.getContId()).andBookTypeEqualTo(GlobalParamSet.getShort(BizConstants.CONTRACT_BOOK_TYPE_CREDIT));
						List<ContractBook> paymentBooks = contractBookMapper.selectByExample(payexample);
						if(null==credictBooks||null==paymentBooks||credictBooks.size()<=0||paymentBooks.size()<=0){
							// 合同账本异常
							throw new BusinessException(ExInfoEnum.VALIDATE_CONTBOOK_NOT_EXSIT);
						}else{
							// 判断信用账本中金额
							ContractBook credictBook = credictBooks.get(0);
							Long payFee = Long.parseLong(contract.getExt1());
							 
							if (0 == credictBook.getAmount() || null == credictBook.getAmount()) {
								// 操作支付账本
									ContractBook contractBook = paymentBooks.get(0);

									ContractBookBo bookBo = new ContractBookBo();
									bookBo.setContractBook(contractBook);
									// 支付账本增加
									bookManagerService.paymentBookIncome(payFee, contract.getContId());
									contractOperService.renewalAuditSuccOper(contract.getContId(), managerId, remark);
									//余额账本
									//distributionService.addBalanceDataBooka(queryContract.getContId(), payFee);
									//总额账本
									//distributionService.addTotalDataBooka(queryContract.getContId(), payFee);
									// 支付流水状态修改
									Payment payment = paymentMapper.selectByPrimaryKey(contract.getPaymentId());
									payment.setPayState(GlobalParamSet.getInteger(BizConstants.PAY_STATE_PAY_SUCC));
									payment.setPayDate(new Date());
									payment.setAuditor(managerId);
									paymentMapper.updateByPrimaryKeySelective(payment);
							} else {
								Long amount = payFee-credictBook.getAmount();
								if(amount<0){
									amount=0L;
									// 扣除信用账本金额
									bookManagerService.creditBookOut(payFee, contract.getContId());
									// 操作支付账本
									// 支付账本增加
									bookManagerService.paymentBookIncome(payFee, contract.getContId());
									contractOperService.renewalAuditSuccOper(contract.getContId(), managerId, remark);
									// 支付流水状态修改
									Payment payment = paymentMapper.selectByPrimaryKey(contract.getPaymentId());
									payment.setPayState(GlobalParamSet.getInteger(BizConstants.PAY_STATE_PAY_SUCC));
									payment.setPayDate(new Date());
									payment.setAuditor(managerId);
									paymentMapper.updateByPrimaryKeySelective(payment);
								}else{
									// 扣除信用账本金额
									bookManagerService.creditBookOut(credictBook.getAmount(), contract.getContId());
									// 操作支付账本
									bookManagerService.paymentBookIncome(payFee, contract.getContId());
									contractOperService.renewalAuditSuccOper(contract.getContId(), managerId, remark);
									// 支付流水状态修改
									Payment payment = paymentMapper.selectByPrimaryKey(contract.getPaymentId());
									payment.setPayState(GlobalParamSet.getInteger(BizConstants.PAY_STATE_PAY_SUCC));
									payment.setPayDate(new Date());
									payment.setAuditor(managerId);
									paymentMapper.updateByPrimaryKeySelective(payment);
								}
							}
							//distributionService.addTotalDataBooka(queryContract.getContId(), payFee);
						}
						
					}
					if (GlobalParamSet.getInteger(BizConstants.CONTRACT_SUB_STATE_RENEWALFAILED) == queryContract
							.getSubState()) {
						//支付流水状态修改
						Payment payment = paymentMapper.selectByPrimaryKey(contract.getPaymentId());
						payment.setPayState(GlobalParamSet.getInteger(BizConstants.PAY_STATE_PAY_CLOSED));
						payment.setPayDate(new Date());
						payment.setAuditor(managerId);
						paymentMapper.updateByPrimaryKeySelective(payment);
						contract.setSubState(queryContract.getSubState());
						contractOperService.renewalAuditFailedOper(contract.getContId(), managerId, remark);

					}
					contractMapper.updateByPrimaryKeySelective(contract);
				} else {
					// 合同状态异常
					throw new BusinessException(ExInfoEnum.VALIDATE_CONT_STATE_EXCPTION);
				}

			} else {
				// 没有操作权限
				throw new NoAccessException();
			}
			return contract.getContId();
		} else {
			// 合同异常
			throw new BusinessException(ExInfoEnum.VALIDATE_CONT_NOT_EXSIT);
		}
		}else{
			// 合同异常
			throw new BusinessException(ExInfoEnum.VALIDATE_CONT_NOT_EXSIT);
		}
	}

	@Override
	public ContractBo renewalApplyView(String contId, String managerId) {
		// 管理员权限--地市级
		User user = userService.findUserByAcctId(managerId);
		// 地市级查询校验
		String regionId = user.getRegionId();
		// 1000代表省级管理员
		Contract contract = contractMapper.selectByPrimaryKey(contId);
		if ((StringUtil.isNotEmpty(regionId)) && (GlobalParamSet.getString(BizConstants.PROVINCE_ADMIN_REGION) != regionId)
				&& (Integer.parseInt(regionId) == contract.getRegionId())) {

			ContractBo contractbo = ContractBo.fromContract(contract);
			return contractbo;
		} else {
			// 没有操作权限
			throw new NoAccessException();
		}
	}

	@Override
	public String renewalApply(ContractBo contractBo, String managerId, String payCert,Long payFee) {
		// 判断是不是属于地市级管理员所属的客户合同
		User bo = userService.findUserByAcctId(managerId);
		// 地市级查询校验
		String regionId = bo.getRegionId();
		// 查询参数
		Contract queryContract = contractBo.toContractt();
		if (null != queryContract && StringUtil.isNotEmpty(queryContract.getContId())) {
			Contract contract = contractMapper.selectByPrimaryKey(queryContract.getContId());

			if (StringUtil.isNotEmpty(regionId) && (GlobalParamSet.getString(BizConstants.PROVINCE_ADMIN_REGION) != regionId)
					&& (Integer.parseInt(regionId) == contract.getRegionId())) {
				// 判断合同状态
				if (GlobalParamSet.getInteger(BizConstants.CONTRACT_STATE_ENABLED) == contract.getState()) {

					contract.setSubState(GlobalParamSet.getInteger(BizConstants.CONTRACT_SUB_STATE_WAITAUDITRENEWAL));
					//  支付金额
					//contract.setPayedFee(contract.getPayedFee()+payFee);
					//本次支付
					contract.setExt1(String.valueOf(payFee));
					// 支付流水号
					String payMentId = sequenceFactory.next(BizConstants.SEQ_KEY_PAYMENT);
					contract.setPaymentId(payMentId);
					// 付费类型
					contract.setPayType(GlobalParamSet.getShort(BizConstants.PAY_TYPE_PREPAY));

					// 生成支付流水
					Payment payment = new Payment();
					payment.setAmount(payFee);
					payment.setApplyDate(new Date());
					payment.setCostType(GlobalParamSet.getInteger(BizConstants.COST_TYPE_ACTIVATE));
					payment.setCustId(contract.getCustId());
					payment.setObjectId(queryContract.getContId());
					payment.setObjectType(GlobalParamSet.getInteger(BizConstants.PAY_OBJECT_TYPE_ADVANCES));
					payment.setOperator(managerId);
					// 支付凭证
					payment.setPayCert(payCert);
					payment.setPaymentId(payMentId);
					payment.setPayState(GlobalParamSet.getInteger(BizConstants.PAY_STATE_PAY_CONFIREMED));
					payment.setPayMode(GlobalParamSet.getInteger(BizConstants.PAY_MODE_BYBANK));
					contractMapper.updateByPrimaryKeySelective(contract);
					paymentMapper.insertSelective(payment);
					contractOperService.renewalApplyOper(contract);
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
			// 查询的合同异常
			throw new BusinessException(ExInfoEnum.VALIDATE_CONT_NOT_EXSIT);
		}
	}
	
	public void checkWaitAuditCont(String custId){
		ContractExample example = new ContractExample();
		example.createCriteria()
		.andCustIdEqualTo(custId)
		.andSubStateEqualTo(GlobalParamSet.getInteger(BizConstants.CONTRACT_SUB_STATE_WAITAUDIT));
		
		List<Contract> contList = contractMapper.selectByExample(example);
		if (null != contList && contList.size() > 0) {
			throw new BusinessException(BizExInfoEnum.CONTRACT_UNIQUE_WAITAUDIT);
		}
		
	}

	@Override
	public void addPersonalContract(Contract contract, int contEffDate) {
		//新增校验： 检查该客户的所有待审核合同，若存在，则无法提交新合同
				checkWaitAuditCont(contract.getCustId());
				//新增校验：合同所在地
				custService.checkCustRegion(contract.getCustId(), String.valueOf(contract.getRegionId()));
				// 步骤1：新增合同
				// 初始化部分默认字段
				// 1. 业务类型： 流量分销
				contract.setBusiType(GlobalParamSet.getString(BizConstants.FLOW_BUSI_TYPE_HN));
				// 2. ID：9位+3位随机码
				contract.setContId(sequenceFactory.next(BizConstants.SEQUENCENAME_CONTRACT));
				// 3. 支付方式：预付费
				contract.setPayType(GlobalParamSet.getShort(BizConstants.ORDER_PREPAY));
				// 4. 创建日期
				contract.setCreateDate(new Date());

				// 5. 设置当前客户名称
				Cust cust = custService.findCustByCustId(contract.getCustId());
				contract.setCustName(cust.getCustName());

				// 6. 获取最晚到期的合同信息，并设置当前合同最早生效日期为最晚到期时间+1天，若没有已生效的合同，则生效日期为当天
				Contract last = findLastContractByCustId(contract.getCustId());
				contract.setEffDate((last == null||last.getExpDate().getTime()<new Date().getTime()) ? new Date() : last.getExpDate());

				// 7. 到期时间
				contract.setExpDate(DateTimeUtil.addDate(contract.getEffDate(), contEffDate, Calendar.MONTH));

				// 8. 设置初始化状态
				contract.setState(GlobalParamSet.getInteger(BizConstants.CONTRACT_STATE_DISABLED));
				contract.setSubState(GlobalParamSet.getInteger(BizConstants.CONTRACT_SUB_STATE_AUDIT));
				contractMapper.insertSelective(contract);

				// 步骤2： 新增合同操作流水
				contractOperService.inputOper(contract);
		
	}

	@Override
	public String renewalPersonalContract(ContractBo contractBo, String managerId, String payCert, Long payFee) {
		// 判断是不是属于地市级管理员所属的客户合同
				User bo = userService.findUserByAcctId(managerId);
				// 地市级查询校验
				String regionId = bo.getRegionId();
				// 查询参数
				Contract queryContract = contractBo.toContractt();
				if (null != queryContract && StringUtil.isNotEmpty(queryContract.getContId())) {
					Contract contract = contractMapper.selectByPrimaryKey(queryContract.getContId());

					if (StringUtil.isNotEmpty(regionId) && (GlobalParamSet.getString(BizConstants.PROVINCE_ADMIN_REGION) != regionId)
							&& (Integer.parseInt(regionId) == contract.getRegionId())) {
						// 判断合同状态和小客户标志
						if (GlobalParamSet.getInteger(BizConstants.CONTRACT_STATE_ENABLED) == contract.getState()) {

							contract.setSubState(GlobalParamSet.getInteger(BizConstants.CONTRACT_SUB_STATE_RENEWALSUC));
							//  支付金额
							contract.setPayedFee(contract.getPayedFee()+payFee);
							//本次支付
							contract.setExt1(String.valueOf(payFee));
							// 支付流水号
							String payMentId = sequenceFactory.next(BizConstants.SEQ_KEY_PAYMENT);
							contract.setPaymentId(payMentId);
							// 付费类型
							contract.setPayType(GlobalParamSet.getShort(BizConstants.PAY_TYPE_PREPAY));

							// 生成支付流水
							Payment payment = new Payment();
							payment.setAmount(payFee);
							payment.setApplyDate(new Date());
							payment.setCostType(GlobalParamSet.getInteger(BizConstants.COST_TYPE_ACTIVATE));
							payment.setCustId(contract.getCustId());
							payment.setObjectId(queryContract.getContId());
							payment.setObjectType(GlobalParamSet.getInteger(BizConstants.PAY_OBJECT_TYPE_ADVANCES));
							payment.setOperator(managerId);
							// 支付凭证
							payment.setPayCert(payCert);
							payment.setPaymentId(payMentId);
							payment.setPayState(GlobalParamSet.getInteger(BizConstants.PAY_STATE_PAY_SUCC));
							payment.setPayMode(GlobalParamSet.getInteger(BizConstants.PAY_MODE_BYBANK));
							contractMapper.updateByPrimaryKeySelective(contract);
							paymentMapper.insertSelective(payment);
							contractOperService.renewalApplyOper(contract);
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
					// 查询的合同异常
					throw new BusinessException(ExInfoEnum.VALIDATE_CONT_NOT_EXSIT);
				}
	}

}
