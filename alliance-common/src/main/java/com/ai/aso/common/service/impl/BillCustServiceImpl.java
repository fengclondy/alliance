package com.ai.aso.common.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ai.aso.common.bo.BillRecordBo;
import com.ai.aso.common.bo.CustBillBo;
import com.ai.aso.common.service.BillCustService;
/**
 * 客户账单管理service实现类
 *<p>Description:</p>
 *
 *@author liuwu
 *@date 2016年9月19日
 *
 */
@Service
public class BillCustServiceImpl implements  BillCustService{

	@Override
	public List<CustBillBo> selectBillCustList(String custId, String billState) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BillRecordBo> selectBillCustDetailList(String custId, String billId) {
		// TODO Auto-generated method stub
		return null;
	}

}
