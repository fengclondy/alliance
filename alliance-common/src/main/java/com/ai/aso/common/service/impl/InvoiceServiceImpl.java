package com.ai.aso.common.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ai.aso.common.bo.InvoiceItemBo;
import com.ai.aso.common.bo.InvoiceRecordBo;
import com.ai.aso.common.service.InvoiceService;
/**
 * 发票管理的service实现类 
 *<p>Description:</p>
 *
 *@author liuwu
 *@date 2016年9月19日
 *
 */
@Service
public class InvoiceServiceImpl implements InvoiceService{

	@Override
	public List<InvoiceRecordBo> selectInvoiceListByCust(String custId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InvoiceItemBo selectInvoiceDetail(String custId, String invoiceId) {
		// TODO Auto-generated method stub
		return null;
	}

}
