package com.ai.aso.common.service.impl;


import com.ai.aso.base.exception.BusinessException;
import com.ai.aso.base.exception.ExInfo;
import com.ai.aso.base.utils.StringUtil;
import com.ai.aso.common.db.dao.CustBillMapper;
import com.ai.aso.common.db.model.CustBill;
import com.ai.aso.common.db.model.CustBillExample;
import com.ai.aso.common.service.BillEntryService;
import com.ai.aso.common.service.CostBillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * description:
 * </p>
 * 入账管理
 * 
 * @author lw
 * @2017/5/3
 */
@Service
public class BillEntryServiceImpl implements BillEntryService {

	@Autowired
	private CustBillMapper custBillMapper;
	@Autowired
	private CostBillService costBillService;
	Logger logger = LoggerFactory.getLogger(BillEntryServiceImpl.class);
	 public void execute(String[] billIdList) {
	        new Worker(billIdList).start();
	    }
	    // 线程内部类，Thread或者Runnable均可
	    private class Worker extends Thread {
	    	private String[] billIdList;
	    	
	        public Worker() {
				super();
			}

			public Worker(String[] billIdList) {
				this.billIdList = billIdList;
			}

			@Override
	        public void run() {
				List<Long> billIds = StringUtil.arrayToAssemble(billIdList);
				Map<String, List<String>> map=BillEntryServiceImpl.this.censusBill(billIdList);
	        	BillEntryServiceImpl.this.billEntry(map,billIds); 
	        	logger.info("入账结束==============线程执行成功！");
	        }
	    }
	@Override
	public Map<String, List<String>> censusBill(String[] billId) {
		Map<String, List<String>> billBatchMap = new HashMap<>();

		// 转换billId
		List<Long> billIdList = StringUtil.arrayToAssemble(billId);
		CustBillExample _example = new CustBillExample();
		_example.createCriteria().andBillIdIn(billIdList);
		List<CustBill> custBillList = custBillMapper.selectByExample(_example);
		//int count=costBillService.lockInbill(billIdList);
		//logger.debug("本次锁定入账记录共【{}】条",count);
	if(custBillList.isEmpty())
			return billBatchMap;
		for (CustBill cb : custBillList) {
			String contId = cb.getContId();
			String billBatch = cb.getBillBatch();

			if (billBatchMap.containsKey(contId)) {
				billBatchMap.get(contId).add(billBatch);
			} else {
				List<String> _billBatchList = new ArrayList<>();
				_billBatchList.add(billBatch);
				billBatchMap.put(contId, _billBatchList);
			}
		}

		return billBatchMap;
	}

	@Override
	public void billEntry(Map<String, List<String>> map,List<Long> billIdList) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		String billMonth = sdf.format(new Date());
		for (String contId : map.keySet()) {
			logger.debug("本次【{}】开始入账",contId);
			List<String> billBatchList = map.get(contId);
			try {
				//入账
				costBillService.dealBill(billMonth, contId,billBatchList.toArray(new String[billBatchList.size()]));
				
			} catch (Exception e) {
				//失败解锁
				costBillService.deblockingBill(billIdList);
				logger.debug("本次【{}】入账失败解除锁定",contId);
				
				logger.error("入账异常:{}",e.getMessage());
				throw new BusinessException(ExInfo.create("F200200036", e.getMessage(), e.getMessage()));
			}
			logger.debug("本次【{}】结束入账",contId);
		}
	}

}
