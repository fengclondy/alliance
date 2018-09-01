package com.ai.aso.common.component.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.aso.common.param.GlobalParamSet;
import com.ai.aso.common.component.CustBillComp;
import com.ai.aso.common.constants.BizConstants;
import com.ai.aso.common.db.dao.DataRecMapper;
import com.ai.aso.common.db.dao.ext.BillRecExtMapper;
import com.ai.aso.common.db.dao.ext.CustBillExtMapper;
import com.ai.aso.common.db.model.BillRec;
import com.ai.aso.common.db.model.CustBill;
import com.ai.aso.common.db.model.DataRec;
import com.ai.aso.common.db.model.DataRecExample;

/**
 * 客户账单service
 * @author bianxiaowen
 *
 */
@Service
public class CustBillCompImpl implements CustBillComp {
	
	Logger logger = LoggerFactory.getLogger(CustBillComp.class);

	@Autowired
	private CustBillExtMapper custBillExtMapper;
	@Autowired
	private BillRecExtMapper billRecExtMapper;
	@Autowired
	private DataRecMapper dataRecMapper;
	
//	@Override
//	public String findNewBillBatch() {
//		
//		String batch = custBillExtMapper.selectNewbillBatch();
//		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
//		String now = sdf.format(new Date());
//		
//		String newBatch = "";
//		if (StringUtils.isEmpty(batch)) {
//			newBatch = now + "01";
//			return newBatch;
//		}
//		
//		String date = batch.substring(0, 6);
//		if (date.equals(now)) {
//			newBatch = String.valueOf(Integer.valueOf(batch) + 1);
//		} else {
//			newBatch = now + "01";
//		}
//		
//		return newBatch;
//	}

//	@Override
//	@Transactional
//	public void billRecGroupCust(String billBatch) {
//		// 按客户和出账批次统计
//		List<BillRec> recList = billRecExtMapper.selectBillRecGroupCust(billBatch);
//		
//		if(recList.size() == 0){
//			logger.info("无需要出账的记录");
//			return;
//		}
//		
//		List<CustBill> cbList = new ArrayList<CustBill>();
//		for (BillRec rec : recList) {
//			CustBill cb = new CustBill();
//			cb.setCustId(rec.getCustId());
//			cb.setCustName(rec.getCustName());
//			cb.setRegionId(rec.getRegionId());
//			cb.setRegionName(rec.getRegionName());
////			cb.setBillDesc(rec.getbil);
//			cb.setAmount(rec.getBillFee());
//			cb.setOweFee(0l);
//			cb.setDiscount(rec.getDiscount());
//			cb.setOffFee(rec.getOffFee());
//			cb.setBillBatch(billBatch);
//			cb.setBillState(GlobalParamSet.getInteger(BizConstants.CUST_BILL_STATE_UNCONFIRM));
//			cb.setContId(rec.getContId());
//			cb.setPayType(rec.getPayType());
//			cb.setCreateDate(new Date());
//			cb.setDataVal(rec.getDataVal());
//			cbList.add(cb);
//		}
//		// 统计结果如客户账单表
//		custBillExtMapper.batchInsert(cbList);
//		
//		// 更新流量分发记录表状态为已出账
//		DataRec record = new DataRec();
//		record.setBillState(GlobalParamSet.getInteger(BizConstants.OUT_BILL_STATE_OK));
//		DataRecExample example = new DataRecExample();
//		example.createCriteria().andBillBatchEqualTo(billBatch);
//		dataRecMapper.updateByExampleSelective(record, example);
//		
//	}


}
