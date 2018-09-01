package com.ai.aso.common.service;

import java.util.List;

import com.ai.aso.common.db.model.CustBill;

public interface BillCustConfirmService {
	/**
	 * 查询所有未确认账单
	 * @return
	 */
	 List<CustBill> findConfirmBill();
	 
	 /**
	  * 确认未确认客户账单
	  */
	 void confirmBill();
}
