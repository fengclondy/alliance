package com.ai.aso.common.db.dao.ext;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.aso.common.db.model.CustBill;

public interface CustBillExtMapper {
	
	public String selectNewbillBatch();

	public int batchInsert(List<CustBill> list);
	
	public List<CustBill> selectCustBillGroupCust(String[] billId);
	
	public int updateBillMonth(@Param("custBill") CustBill custBill, @Param("billId") String[] billId);
	public String selectTotalVal(String custId);
	
	public List<CustBill> selectCustBillByCust(@Param("billBatch") String[] billBatch, @Param("contId") String contId);
	public int updateBillMonthByCust(@Param("custBill") CustBill custBill, @Param("contId") String contId, @Param("billBatch") String[] billBatch);
}
