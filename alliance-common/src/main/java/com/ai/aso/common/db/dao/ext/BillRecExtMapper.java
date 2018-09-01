package com.ai.aso.common.db.dao.ext;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.aso.common.db.model.BillRec;

public interface BillRecExtMapper {

	int batchInsert(List<BillRec> list);
	/**
	 * 按合同查询计费清单--新出账服务
	 * @param billBatch
	 * @param contId
	 * @return
	 */
	List<BillRec> queryBillRecByCont(@Param("billBatch") String billBatch, @Param("contId") String contId);
	List<BillRec> selectBillRecGroupCust(String billBatch);
	
	List<BillRec> selectBillRecGroupRegion(String billMonth);
	
	int updateBillMonth(@Param("billMonth") String billMonth, @Param("billId") String[] billId);
	
	 String selectNewbillBatch();
	 List<BillRec> selectBillRecByCust(@Param("contId") String contId, @Param("billBatch") String[] billBatch);
	 /**
	  * 更新入账账期---新入账服务
	  * @param billMonth
	  * @param custId
	  * @param billBatch
	  * @return
	  */
	 int updateBillMonthByCust(@Param("billMonth") String billMonth, @Param("contId") String contId, @Param("billBatch") String[] billBatch);
     /**
      * 
      * @param batchCode
      * @return
      */
	 List<BillRec> selectBillRec(@Param("batchCode") String batchCode);
}