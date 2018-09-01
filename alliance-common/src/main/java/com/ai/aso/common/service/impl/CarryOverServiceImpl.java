package com.ai.aso.common.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ai.aso.common.service.ContractOperService;
import com.ai.aso.common.service.RegionService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ai.aso.common.param.GlobalParamSet;
import com.ai.aso.common.constants.BizConstants;
import com.ai.aso.common.db.dao.ContractBookMapper;
import com.ai.aso.common.db.dao.ContractMapper;
import com.ai.aso.common.db.dao.CostBillChargeMapper;
import com.ai.aso.common.db.dao.CostBillItemMapper;
import com.ai.aso.common.db.dao.DataBookaMapper;
import com.ai.aso.common.db.dao.PaymentMapper;
import com.ai.aso.common.db.dao.ext.CostBillItemExtMapper;
import com.ai.aso.common.db.dao.ext.RegionExtMapper;
import com.ai.aso.common.db.model.BillRec;
import com.ai.aso.common.db.model.Contract;
import com.ai.aso.common.db.model.ContractBook;
import com.ai.aso.common.db.model.ContractBookExample;
import com.ai.aso.common.db.model.ContractExample;
import com.ai.aso.common.db.model.CostBillCharge;
import com.ai.aso.common.db.model.CostBillItem;
import com.ai.aso.common.db.model.CostBillItemExample;
import com.ai.aso.common.db.model.DataBooka;
import com.ai.aso.common.db.model.DataBookaExample;
import com.ai.aso.common.db.model.Payment;
import com.ai.aso.common.service.CarryOverService;
import com.ai.aso.security.model.Principal;
import com.ai.aso.common.sequence.SequenceFactory;
@Service
public class CarryOverServiceImpl implements CarryOverService{
	@Autowired 
	private ContractMapper contractMapper;
	@Autowired 
	private ContractBookMapper contractBookMapper;
	@Autowired 
	private DataBookaMapper dataBookaMapper;
	@Autowired
	private SequenceFactory sequenceFactory;
	@Autowired
	private PaymentMapper paymentMapper;	
    @Autowired
    private CostBillChargeMapper costBillChargeMapper;
    @Autowired
    private CostBillItemMapper costBillItemMapper;
    @Autowired
    private CostBillItemExtMapper costBillItemExtMapper;
    @Autowired
    private RegionExtMapper regionExtMapper;
    @Autowired
    private ContractOperService contractOperService;
    @Autowired
    private RegionService regionService;

    Logger logger = LoggerFactory.getLogger(CostBillServiceImpl.class);
    
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void dealCont(String billMonth, String custId,List<Contract> list,Long amount) {
        costBillEntry(billMonth, custId,list);
        repartitionBill(billMonth, custId,list,amount);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int costBillEntry(String billMonth, String custId,List<Contract> list) {
    	Subject subject = SecurityUtils.getSubject();
		Principal user = (Principal) subject.getPrincipals().getPrimaryPrincipal();
		String managerId = user.getAccId();
        int rs = 0;
        logger.debug("本次【{}】合同列收统计入账数据开始",custId);
        List<String> contId=new ArrayList<>();
        for (Contract _contract : list) {
        	contId.add(_contract.getContId());
            CostBillCharge cost = new CostBillCharge();
            cost.setBillMonth(billMonth);
            cost.setCustId(custId);
            cost.setCustName(_contract.getCustName());
            cost.setRegionId(_contract.getRegionId());
            cost.setRegionName(regionService.findRegionByRegionId(_contract.getRegionId()).getRegionName());
            cost.setContId(_contract.getContId());
            cost.setBillFee(Long.parseLong(_contract.getExt3()));
            cost.setTotalFee(Long.parseLong(_contract.getExt3()));
            cost.setOffFee(0l);
            cost.setDiscount(0);
            cost.setState(GlobalParamSet.getInteger(BizConstants.COST_BILL_STATE_NOT));
            cost.setIsInvcd(GlobalParamSet.getInteger(BizConstants.IS_INVCD_NOT));
            cost.setBegDate(new Date());
            cost.setCreateDate(new Date());
            cost.setUsedData(0l);
            cost.setExpData(0l);
            cost.setExt1("200");
            logger.debug("【{}】合同列收客户列收更新入账数据",custId);
            contractOperService.contColumnOper(_contract.getContId(), managerId);
            rs += costBillChargeMapper.insertSelective(cost);
		}
        //更新合同信息 账本信息金额全部设置为0
        Contract contract = new Contract();
        contract.setExt1(null);
        contract.setPayedFee(0L);
        contract.setState(GlobalParamSet.getInteger(BizConstants.CONTRACT_STATE_CLOSED));
        contract.setSubState(GlobalParamSet.getInteger(BizConstants.CONTRACT_SUB_STATE_CLOSED));
        ContractExample example =new ContractExample();
        example.createCriteria().andContIdIn(contId);
        rs +=contractMapper.updateByExampleSelective(contract, example);
        ContractBook contractBook = new ContractBook();
        contractBook.setAmount(0L);
        contractBook.setState(GlobalParamSet.getInteger(BizConstants.CONTRACT_BOOK_STATE_CLOSED));
        ContractBookExample _example = new ContractBookExample();
        _example.createCriteria().andContIdIn(contId);
        rs +=contractBookMapper.updateByExampleSelective(contractBook, _example);
        logger.debug("本次【{}】合同列收统计入账数据结束",custId);        
        return rs;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int repartitionBill(String billMonth, String custId,List<Contract> list,Long balance) {
        // 根据成本中心地区分摊客户收入
    	Contract _contract=list.get(0);
        int rs = 0;
        logger.debug("本次【{}】合同列收收入摊分开始",custId);
        // 获取所有地市的id
        List<Integer> regionIdList = regionExtMapper.selectRegionId();
        // 如果某客户的一些地市没有清单，则加入一条使用流量为0的清单。
        List<BillRec> addList = new ArrayList<>();
        for (Integer regionId : regionIdList) {
            BillRec rect = new BillRec();
                if (_contract.getRegionId().equals(regionId)) {
                     rect.setBillFee(balance);
                     rect.setTotalFee(balance);
                }else{
                    rect.setBillFee(0l);
                    rect.setTotalFee(0l);
                }  
                rect.setBillMonth(billMonth);
                rect.setRegionId(regionId);
                rect.setRegionName(regionService.findRegionByRegionId(regionId).getRegionName());
                rect.setContId(_contract.getContId());
                rect.setCostRegion(_contract.getRegionId());
                rect.setOffFee(0l);
                rect.setDiscount(0);
                rect.setDataVal(0l);       
                addList.add(rect);
        }
        List<CostBillItem> iList = new ArrayList<>();

        Double amount = 0.0;
        // 当前地市的入账摊分项
        CostBillItem curItem = new CostBillItem();
        // 查看该账期客户是否有摊分如果有的话就在原来摊分上累加，没有则新增一条
        CostBillItemExample example = new CostBillItemExample();
        example.createCriteria().andBillMonthEqualTo(billMonth).andCustIdEqualTo(custId);
        List<CostBillItem> costBillItems = costBillItemMapper
                .selectByExample(example);
        if (costBillItems.isEmpty()) {
            amount = 0.0;
            // 根据比例计算各地区收入
            for (BillRec rec : addList) {
                CostBillItem item = new CostBillItem();
                item.setBillMonth(billMonth);
                item.setCustId(custId);
                item.setCustName(_contract.getCustName());
                item.setRegionId(rec.getRegionId());
                item.setRegionName(rec.getRegionName());
                item.setCostRegion(rec.getRegionId());
                item.setPayType(GlobalParamSet.getShort(BizConstants.PAY_TYPE_PREPAY));
                item.setContId(rec.getContId());
                item.setUsedData(rec.getDataVal());
                item.setExpData(0l);
                item.setBusiMode(100);
                item.setBillFee(rec.getBillFee());
                item.setTotalFee(rec.getTotalFee());
                item.setOffFee(rec.getOffFee());
                item.setDiscount(rec.getDiscount());

                if (!rec.getRegionId().equals(rec.getCostRegion())) {
                    Long _total = rec.getBillFee();
                    Double amountTemp = _total * 0.0;// TODO
                    amount += amountTemp;
                    item.setIncome(_total - amountTemp.longValue());
                } else {
                    amount += rec.getBillFee();
                    curItem = item;
                }

                iList.add(item);
            }
            curItem.setIncome(amount.longValue());
            logger.debug("【{}】合同列收本月首次入账收入摊入",custId);
            rs = costBillItemExtMapper.batchInsert(iList);
        } else {
            amount = 0.0;
            List<CostBillItem> belongItems = null;
            for (BillRec rec : addList) {
                if (rec.getRegionId().equals(rec.getCostRegion())) {
                    //取出合同归属地摊分
                    CostBillItemExample example_ = new CostBillItemExample();
                    example_.createCriteria().andBillMonthEqualTo(rec.getBillMonth())
                            .andContIdEqualTo(rec.getContId()).andCostRegionEqualTo(rec.getRegionId());
                    belongItems = costBillItemMapper
                            .selectByExample(example_);
                }
            }
            for (BillRec rec : addList) {
                CostBillItemExample _example = new CostBillItemExample();
                example.createCriteria().andBillMonthEqualTo(rec.getBillMonth())
                        .andContIdEqualTo(rec.getContId()).andCostRegionEqualTo(rec.getCostRegion());
                List<CostBillItem> costBillItem = costBillItemMapper.selectByExample(_example);
                CostBillItem opItem = null;
                if (!costBillItem.isEmpty()) {
                    opItem = costBillItem.get(0);
                    CostBillItem belongItem = belongItems.get(0);
                    curItem = belongItem;
                    opItem.setCostItemId(opItem.getCostItemId());
                    opItem.setBillFee(rec.getBillFee() + opItem.getBillFee());
                    opItem.setTotalFee(rec.getTotalFee() + opItem.getTotalFee());
                    opItem.setOffFee(0L);
                    if (!rec.getRegionId().equals(rec.getCostRegion())) {
                        Long _total = rec.getBillFee();
                        Double amountTemp = _total * 0.0;// TODO
                        amount += amountTemp;
                        opItem.setIncome(_total - amountTemp.longValue() + opItem.getIncome());
                    } else {
                        amount += rec.getBillFee();
                        opItem.setCostItemId(opItem.getCostItemId());
                    }
                    logger.debug("【{}】合同列收本月多次入账更新非属地摊分",custId);
                    rs = costBillItemMapper.updateByPrimaryKeySelective(opItem);
                }
            }
            curItem.setIncome(amount.longValue() + curItem.getIncome());
            curItem.setCostItemId(curItem.getCostItemId());
            logger.debug("【{}】合同列收本月多次入账更新属地摊分",custId);
            rs += costBillItemMapper.updateByPrimaryKeySelective(curItem);
        }
        logger.debug("本次【{}】合同列收收入摊分结束",custId);
        return rs;
    }
	@Override
	public boolean cheakState(String contId) {
		Contract contract=contractMapper.selectByPrimaryKey(contId);
		return !(contract.getExpDate().getTime() <= new Date().getTime()) || !(contract.getState() == GlobalParamSet.getInteger(BizConstants.CONTRACT_STATE_ENABLED));
	}

//	@Override
//	public Long cheakAmount(String contId,Long amount) {
//		ContractBookExample _example = new ContractBookExample();
//		_example.createCriteria()
//				.andContIdEqualTo(contId)
//				.andBookTypeEqualTo(
//						GlobalParamSet
//								.getShort(BizConstants.CONTRACT_BOOK_TYPE_PAYMENT))
//				.andStateEqualTo(
//						GlobalParamSet
//								.getInteger(BizConstants.CONTRACT_BOOK_STATE_NORMAL));
//		List<ContractBook> contractBooks = contractBookMapper
//				.selectByExample(_example);
//		DataBookaExample example2 = new DataBookaExample();
//		example2.createCriteria().andContIdEqualTo(contId);
//		List<DataBooka> dataBookas = dataBookaMapper.selectByExample(example2);
//		Long currentVal = 0L;
//		if (!contractBooks.isEmpty() && !dataBookas.isEmpty()) {
//			ContractBook contractBook = contractBooks.get(0);
//			DataBooka dataBooka = dataBookas.get(0);
//			Long cumuVal = dataBooka.getCumuVal();
//			currentVal = (contractBook.getAmount() - cumuVal) / 1000;
//		}
//		return currentVal-amount;
//	}

	@Override
	public int insertPaymentIn(Contract contract,String managerId) {
		Payment payment = new Payment();
		// 支付流水号
		String payMentId = sequenceFactory.next(BizConstants.SEQ_KEY_PAYMENT);
		payment.setAmount(Long.parseLong(contract.getExt3()));
		payment.setApplyDate(new Date());
		payment.setCostType(GlobalParamSet.getInteger(BizConstants.COST_TYPE_ACTIVATE));
		payment.setCustId(contract.getCustId());
		payment.setObjectId(contract.getContId());
		payment.setObjectType(GlobalParamSet.getInteger(BizConstants.PAY_OBJECT_TYPE_CARRY));
		payment.setOperator(managerId);
		// 支付凭证
		payment.setPaymentId(payMentId);
		payment.setPayState(GlobalParamSet.getInteger(BizConstants.PAY_STATE_PAY_CARRYIN));
		payment.setPayMode(GlobalParamSet.getInteger(BizConstants.PAY_MODE_BYBANK));
		
		return paymentMapper.insertSelective(payment);
	}

    @Override
    public int insertPaymentOut(Contract contract,String managerId) {
        Payment payment = new Payment();
        // 支付流水号
        String payMentId = sequenceFactory.next(BizConstants.SEQ_KEY_PAYMENT);
        payment.setAmount(Long.parseLong(contract.getExt3()));
        payment.setApplyDate(new Date());
        payment.setCostType(GlobalParamSet.getInteger(BizConstants.COST_TYPE_ACTIVATE));
        payment.setCustId(contract.getCustId());
        payment.setObjectId(contract.getContId());
        payment.setObjectType(GlobalParamSet.getInteger(BizConstants.PAY_OBJECT_TYPE_CARRY));
        payment.setOperator(managerId);
        // 支付凭证
        payment.setPaymentId(payMentId);
        payment.setPayState(GlobalParamSet.getInteger(BizConstants.PAY_STATE_PAY_CARRYOUT));
        payment.setPayMode(GlobalParamSet.getInteger(BizConstants.PAY_MODE_BYBANK));

        return paymentMapper.insertSelective(payment);
    }


	@Override
	public Long getBlance(String contId) {
		ContractBookExample _example = new ContractBookExample();
		_example.createCriteria()
				.andContIdEqualTo(contId)
				.andBookTypeEqualTo(
						GlobalParamSet
								.getShort(BizConstants.CONTRACT_BOOK_TYPE_PAYMENT))
				.andStateEqualTo(
						GlobalParamSet
								.getInteger(BizConstants.CONTRACT_BOOK_STATE_NORMAL));
		List<ContractBook> contractBooks = contractBookMapper
				.selectByExample(_example);
		DataBookaExample example2 = new DataBookaExample();
		example2.createCriteria().andContIdEqualTo(contId);
		List<DataBooka> dataBookas = dataBookaMapper.selectByExample(example2);
		Long currentVal = 0L;
		if (!contractBooks.isEmpty() && !dataBookas.isEmpty()) {
			ContractBook contractBook = contractBooks.get(0);
			DataBooka dataBooka = dataBookas.get(0);
			Long cumuVal = dataBooka.getCumuVal();
			currentVal = (contractBook.getAmount() - cumuVal);
		}
		return currentVal;
	}

	@Override
	public boolean validatorState(String contId) {
		Contract contract=contractMapper.selectByPrimaryKey(contId);
		if(!(contract.getExpDate().getTime()>new Date().getTime())||!(contract.getEffDate().getTime()<=new Date().getTime())||!(contract.getState()==GlobalParamSet.getInteger(BizConstants.CONTRACT_STATE_ENABLED)))
			return true;
		
			return false;
	}
	
	/**
	 * 获取存在余额的合同
	 * 
	 * @return
	 */
	public List<String> checkCurrBalance() {
		List<String> contIds = null;
		ContractBookExample example = new ContractBookExample();
		example.createCriteria()
				.andBookTypeEqualTo(
						GlobalParamSet
								.getShort(BizConstants.CONTRACT_BOOK_TYPE_PAYMENT))
				.andStateEqualTo(
						GlobalParamSet
								.getInteger(BizConstants.CONTRACT_BOOK_STATE_NORMAL));
		List<ContractBook> contractBooks = contractBookMapper
				.selectByExample(example);
		if (null != contractBooks && contractBooks.size() > 0) {
			contIds = new ArrayList<>();
			for (ContractBook contractBook : contractBooks) {
				DataBookaExample example2 = new DataBookaExample();
				example2.createCriteria().andContIdEqualTo(
						contractBook.getContId());
				List<DataBooka> dataBookas = dataBookaMapper
						.selectByExample(example2);
				// 总使用金额
				Long cumuVal = 0l;
				if (!dataBookas.isEmpty()) {
					cumuVal = dataBookas.get(0).getCumuVal();
				}
				Double currentVal = (contractBook.getAmount() - cumuVal) / 1000.000;
				if (currentVal > 0) {
					contIds.add(contractBook.getContId());
				}
			}

		}
		return contIds;
	}
}
