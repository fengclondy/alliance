package com.ai.aso.common.service.impl;

import com.ai.aso.base.utils.StringUtil;
import com.ai.aso.common.db.model.DataRec;
import com.ai.aso.common.service.OutBillInterfaceService;
import com.ai.aso.common.service.OutBillService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * <p>description:</p>
 *
 * @author lw
 * @2017/5/8
 */
@Service
public class OutBillInterfaceServiceImpl implements OutBillInterfaceService {
	private Logger logger = LoggerFactory.getLogger(OutBillInterfaceServiceImpl.class);
    @Autowired
    private OutBillService outBillService;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void dealBill(String contId, String billBatch) {
        logger.info("本次【{}】客户出账开始！", contId);

        int count = outBillService.lockBillDataRec(contId, billBatch);
        if (count > 0) {

            outBillService.billingRec(contId, billBatch);
        }
        outBillService.completeBillState(contId, billBatch);
        logger.info("本次【{}】客户出账结束！", contId);
    }

    @Override
    public void outBill() {
        //本次出账批次
        String billBatch = outBillService.findNewBillBatch();
        Map<String, List<DataRec>> dataRecMap = outBillService.groupingBill(billBatch);
       if(!dataRecMap.isEmpty())  	   
    	   for (String contId : dataRecMap.keySet()) {
    		   dealBill(contId, billBatch);
    	   }
    }
}