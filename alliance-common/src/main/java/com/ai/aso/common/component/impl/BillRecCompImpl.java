package com.ai.aso.common.component.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.aso.common.param.GlobalParamSet;
import com.ai.aso.common.bo.DataRecBo;
import com.ai.aso.common.component.BillRecComp;
import com.ai.aso.common.constants.BizConstants;
import com.ai.aso.common.db.dao.CustMapper;
import com.ai.aso.common.db.dao.DataRecMapper;
import com.ai.aso.common.db.dao.RegionMapper;
import com.ai.aso.common.db.dao.ext.BillRecExtMapper;
import com.ai.aso.common.db.model.BillRec;
import com.ai.aso.common.db.model.Cust;
import com.ai.aso.common.db.model.DataRec;
import com.ai.aso.common.db.model.DataRecExample;
import com.ai.aso.common.db.model.Region;
import com.ai.aso.common.utils.DateTimeUtil;
import com.ai.aso.common.sequence.SequenceFactory;

@Service
public class BillRecCompImpl implements BillRecComp {
	
	Logger logger = LoggerFactory.getLogger(BillRecCompImpl.class);
	
	@Autowired
	private BillRecExtMapper billRecExtMapper;
	@Autowired
	private DataRecMapper dataRecMapper;
	@Autowired
	private CustMapper custMapper;
	@Autowired
	private RegionMapper regionMapper;
	@Autowired
	private SequenceFactory sequenceFactory;

//	@Override
//	@Transactional
//	public void syncBillRec(String billBatch) {
//		DataRec dataRec = new DataRec();
//		dataRec.setBillState(GlobalParamSet.getInteger(BizConstants.OUT_BILL_STATE_ING));
//		dataRec.setBillBatch(billBatch);
//		
//		DataRecExample example = new DataRecExample();
//		example.createCriteria().andBillStateEqualTo(GlobalParamSet.getInteger(BizConstants.OUT_BILL_STATE_NOT)).andEndDateLessThan(DateTimeUtil.getBeginDate(new Date()));
//		// 更新流量分发记录表的出账批次和出账状态
//		int count = dataRecMapper.updateByExampleSelective(dataRec, example);
//		if(count == 0){
//			logger.info("没有需要出账的记录");
//			return;
//		}
//		
//		// 查找流量分发记录表中出账状态为出账中的记录
//		DataRecExample example2 = new DataRecExample();
//		example2.createCriteria().andStateEqualTo((short)2).andBillBatchEqualTo(billBatch)
//			.andBillStateEqualTo(GlobalParamSet.getInteger("OUT_BILL_STATE_ING"));
//		
//		List<DataRec> datalist = dataRecMapper.selectByExample(example2);
//		
//		List<DataRecBo> boList = DataRecBo.convertList(datalist);
//		
//		List<BillRec> reclist = new ArrayList<BillRec>();
//		logger.info("出账的记录数：{}", datalist.size());
//		
//		for (DataRecBo bo : boList) {
//			BillRec bill = new BillRec();
//			bill.setBillRecId(sequenceFactory.nextLong("sqName_billRec"));
//			bill.setBillBatch(bo.getBillBatch());
//			bill.setCustId(bo.getCustId());
//			Cust cust = custMapper.selectByPrimaryKey(bo.getCustId());
//			bill.setCustName(cust.getCustName());
//			bill.setBusiMode(bo.getBusiMode());
//			bill.setSourceType(100);//TODO
//			bill.setContId(bo.getContId());
//			bill.setPayType((short)200);//TODO
//			bill.setRecNo(bo.getRecNo());
//			bill.setRecClass(bo.getRecClass());
//			bill.setRecMode(bo.getRecMode());
//			bill.setServId(bo.getServId());
//			bill.setUserNbr(bo.getUserNbr());
//			bill.setGoodsId(bo.getGoodsId());
//			bill.setGoodsName(bo.getGoodsName());
//			bill.setDataVal(bo.getDataVal());
//			bill.setBillFee(bo.getBillFee());
//			bill.setTotalFee(bo.getTotalFee());
//			bill.setOffFee(bo.getOffFee()==null?0l:bo.getOffFee());
//			bill.setDiscount(bo.getDiscount()==null?0:bo.getDiscount());
//			bill.setRemarks(bo.getRemarks());
//			bill.setRecDate(bo.getEndDate());
//			bill.setRegionId(Integer.valueOf(cust.getRegionId()));
//			Region region = regionMapper.selectByPrimaryKey(Integer.valueOf(cust.getRegionId()));
//			bill.setRegionName(region.getRegionName());
//			bill.setCostRegion(bo.getCostRegion());
//			bill.setCostCenter(bo.getCostCenter());
//			bill.setBillOfferId(bo.getOfferId());
//			bill.setDataType(bo.getDataType());
////			bill.setDataBookId()
//			reclist.add(bill);
//		}
//		
//		billRecExtMapper.batchInsert(reclist);
//		
//	}

}
