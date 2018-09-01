package com.ai.aso.common.db.dao.ext;

import org.apache.ibatis.annotations.Param;

public interface BillExtMapper {

	int batchObtainBillRec(String billBatch);
	/**
	 * 批量插入流量计费表--新出账服务
	 * @param contId
	 * @param billBatch
	 * @return
	 */
	int ObtainBillRec(@Param("contId") String contId, @Param("billBatch") String billBatch);
	int updateCostRate(@Param("billBatch") String billBatch,
                       @Param("custId") String custId, @Param("custName") String custName,
                       @Param("costRate") Integer costRate);
	/**
	 * 新出账服务
	 * @param billBatch
	 * @param contId
	 * @param custName
	 * @param costRate
	 * @return
	 */
	int updateCostRateCont(@Param("billBatch") String billBatch,
                           @Param("contId") String contId, @Param("custName") String custName,
                           @Param("costRate") Integer costRate);

}