package com.ai.aso.common.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ai.aso.common.component.CostBillComp;
import com.ai.aso.common.component.CostBillItemComp;
import com.ai.aso.common.component.CustBillComp;
import com.ai.aso.common.component.OutBillComp;
import com.ai.aso.common.service.BillManagerService;
@Deprecated
@Service
public class BillManagerServiceImpl implements BillManagerService {

	Logger logger = LoggerFactory.getLogger(BillManagerServiceImpl.class);

	@Autowired
	private OutBillComp outBillComp;

	@Autowired
	private CustBillComp custBillComp;

	@Autowired
	private CostBillComp costBillComp;

	@Autowired
	private CostBillItemComp costBillItemComp;

	@Override
	public void outBill() {
		// 出账统计
		try {
			outBillComp.billStat();
		} catch (Exception e) {
			logger.error("本次出账失败！", e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void inBill(String[] billId) {
		// 根据当前时间获取入账账期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		String billMonth = sdf.format(new Date());
		//查出所有入账的合同
		// 统计入账数据
		costBillComp.custBillGroupCust(billMonth, billId);

		// 客户收入分摊
		costBillItemComp.repartitionBill(billMonth);

	}

}
