package com.ai.aso.common.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ai.aso.common.param.GlobalParamSet;
import com.ai.aso.common.constants.BizConstants;
import com.ai.aso.common.db.dao.CustBillMapper;
import com.ai.aso.common.db.model.CustBill;
import com.ai.aso.common.db.model.CustBillExample;
import com.ai.aso.common.service.BillCustConfirmService;
@Service
public class BillCustConfirmServiceImpl implements BillCustConfirmService{
	@Autowired
	private CustBillMapper custBillMapper;
	@Override
	public List<CustBill> findConfirmBill() {
		//查询待确认账单
				CustBillExample example = new CustBillExample();
				example.createCriteria().andBillStateEqualTo(GlobalParamSet.getInteger(BizConstants.CUST_BILL_STATE_UNCONFIRM));
				
				List<CustBill> list = custBillMapper.selectByExample(example);
				
				return list;
	}

	@Override
	public void confirmBill() {
		// TODO Auto-generated method stub
		List<CustBill> custBills =findConfirmBill();
		int UNIT=GlobalParamSet.getInteger(BizConstants.CUST_BILL_COMFIRE_TIME_UNIT);
		if(null!=custBills&&custBills.size()>0){
			for (CustBill custBill : custBills) {	
				if((new Date().getTime()-custBill.getCreateDate().getTime())/UNIT>=GlobalParamSet.getLong(BizConstants.CUST_BILL_COMFIRE_TIME)){
					custBill.setBillState(GlobalParamSet.getInteger(BizConstants.CUST_BILL_STATE_CONFIRMED));
					custBill.setConfirmDate(new Date());					
					custBillMapper.updateByPrimaryKeySelective(custBill);
				}
				
			}
		}
		
	}
}