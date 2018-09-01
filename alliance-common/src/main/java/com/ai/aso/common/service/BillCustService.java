package com.ai.aso.common.service;

import java.util.List;

import com.ai.aso.common.bo.BillRecordBo;
import com.ai.aso.common.bo.CustBillBo;



/**
 * 客户账单管理service接口
 *<p>Description:</p>
 *
 *@author liuwu
 *@date 2016年9月14日
 *
 */
public interface BillCustService {
	/**
	 * 查询客户账单
	 * @param custId
	 * @param billState
	 * @return
	 */
	List<CustBillBo> selectBillCustList(String custId, String billState);
	/**
	 * 查询客户账单详情
	 * @param custId
	 * @param billId
	 * @return
	 */
	List<BillRecordBo> selectBillCustDetailList(String custId, String billId);
}
