package com.ai.aso.common.component.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.aso.common.param.GlobalParamSet;
import com.ai.aso.common.component.CostBillComp;
import com.ai.aso.common.constants.BizConstants;
import com.ai.aso.common.db.dao.ContractMapper;
import com.ai.aso.common.db.dao.CostBillMapper;
import com.ai.aso.common.db.dao.ext.BillRecExtMapper;
import com.ai.aso.common.db.dao.ext.CostBillExtMapper;
import com.ai.aso.common.db.dao.ext.CustBillExtMapper;
import com.ai.aso.common.db.dao.ext.DataRecExtMapper;
import com.ai.aso.common.db.model.BillRec;
import com.ai.aso.common.db.model.BillRecExample;
import com.ai.aso.common.db.model.Contract;
import com.ai.aso.common.db.model.ContractExample;
import com.ai.aso.common.db.model.CostBill;
import com.ai.aso.common.db.model.CostBillExample;
import com.ai.aso.common.db.model.CustBill;

@Service
public class CostBillCompImpl implements CostBillComp {
	
	@Autowired
	private CustBillExtMapper custBillExtMapper;
	@Autowired
	private CostBillExtMapper costBillExtMapper;
	@Autowired
	private BillRecExtMapper billRecExtMapper;
	@Autowired
	private DataRecExtMapper dataRecExtMapper;
	@Autowired
	private CostBillMapper costBillMapper;
	@Autowired
	private ContractMapper contractMapper;
	@Override
	@Transactional
	public void custBillGroupCust(String billMonth, String[] billId) {
		// 从客户账单表获取需要统计的入账数据
		List<CustBill> cbList = custBillExtMapper.selectCustBillGroupCust(billId);
		
		List<CostBill> costList = new ArrayList<CostBill>();
		for (CustBill cb : cbList) {
			CostBill cost = new CostBill();
			cost.setBillMonth(billMonth);
			cost.setCustId(cb.getCustId());
			cost.setCustName(cb.getCustName());
			cost.setRegionId(cb.getRegionId());
			cost.setRegionName(cb.getRegionName());
			cost.setContId(cb.getContId());
			cost.setUsedData(cb.getDataVal());
			cost.setExpData(0l);
			cost.setBillFee(cb.getAmount());
			cost.setTotalFee(cb.getAmount() + (cb.getOffFee()==null?0:cb.getOffFee()));
			cost.setOffFee(cb.getOffFee()==null?0:cb.getOffFee());
			cost.setDiscount(0);
			cost.setState(GlobalParamSet.getInteger(BizConstants.COST_BILL_STATE_NOT));
			cost.setIsInvcd(GlobalParamSet.getInteger(BizConstants.IS_INVCD_NOT));
			cost.setBegDate(new Date());
			cost.setCreateDate(new Date());
			Long totalPayFee=getTotalPayedFee(cb.getCustId());
			Long lastPayedFee= getLastPayedFee(cb.getCustId());
			Long lastBlanceFee=getLastBlanceFee(cb.getCustId());
			// ext1 该客户当前缴费总金额，取合同中的payed_fee
			cost.setExt1(String.valueOf(totalPayFee));   
			// ext2 本期缴费金额，本期缴费总额-上期缴费总额
			cost.setExt2(String.valueOf(totalPayFee-lastPayedFee));
			// ext3 本期余额，上期余额+本期缴费金额-本期入账金额
			cost.setExt3(String.valueOf(lastBlanceFee+(totalPayFee-lastPayedFee)-cb.getAmount()));
			costList.add(cost);
		}
		costBillExtMapper.batchInsert(costList);
		
		// 更新表的入账账期
		CustBill custBill = new CustBill();
		custBill.setBillMonth(billMonth);
		custBill.setBillState(GlobalParamSet.getInteger(BizConstants.CUST_BILL_STATE_INBILL));
		custBill.setBillDate(new Date());
		custBillExtMapper.updateBillMonth(custBill, billId);
		billRecExtMapper.updateBillMonth(billMonth, billId);
		dataRecExtMapper.updateBillMonth(billMonth, GlobalParamSet.getInteger(BizConstants.OUT_BILL_STATE_IN), billId);
	}
	
	/**
	 * 获取该用户缴费总额
	 * @param custId
	 * @return
	 */
	private Long getTotalPayedFee(String custId){
		//
		Long totalPayedFee=0l;
		ContractExample example = new ContractExample();
		example.createCriteria().andCustIdEqualTo(custId);
		List<Contract> contracts =contractMapper.selectByExample(example);
		if(null!=contracts&&contracts.size()>0){
			for (Contract contract : contracts) {
				totalPayedFee=totalPayedFee+contract.getPayedFee();
			}
		}
		return totalPayedFee;
	}
	/**
	 * 获取客户上期缴费总额
	 * @param custId
	 * @return
	 */
	private Long getLastPayedFee(String custId){
		CostBillExample example =new CostBillExample();
		Long lastPayedFee=0l;
		example.createCriteria().andCustIdEqualTo(custId);
		if(costBillMapper.countByExample(example)>0){
			example.setOrderByClause("Create_Date DESC");
			List<CostBill> costBills = costBillMapper.selectByExample(example);
			lastPayedFee= lastPayedFee+Long.parseLong(costBills.get(0).getExt1());
		}
		return lastPayedFee;
	}
	
	/**
	 * 获取客户上期余额
	 * @param custId
	 * @return
	 */
	private Long getLastBlanceFee(String custId){
		CostBillExample example =new CostBillExample();
		Long lastBlanceFee=0l;
		example.createCriteria().andCustIdEqualTo(custId);
		if(costBillMapper.countByExample(example)>0){
			example.setOrderByClause("Create_Date DESC");
			List<CostBill> costBills = costBillMapper.selectByExample(example);
			lastBlanceFee= lastBlanceFee+Long.parseLong(costBills.get(0).getExt3());
		}
		return lastBlanceFee;
	}

}
