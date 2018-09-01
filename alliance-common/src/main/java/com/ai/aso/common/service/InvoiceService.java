package com.ai.aso.common.service;

import java.util.List;

import com.ai.aso.common.bo.InvoiceItemBo;
import com.ai.aso.common.bo.InvoiceRecordBo;


/**
 * 发票管理的service接口
 *<p>Description:</p>
 *
 *@author liuwu
 *@date 2016年9月14日
 *
 */
public interface InvoiceService {
	/**
	 * 客户发票列表
	 * @param custId
	 * @return
	 */
	List<InvoiceRecordBo> selectInvoiceListByCust(String custId);
	
	/**
	 * 发票详情
	 * @param custId
	 * @param invoiceId
	 * @return
	 */
	InvoiceItemBo  selectInvoiceDetail(String custId, String invoiceId);
}
