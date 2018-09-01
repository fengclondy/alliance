package com.ai.aso.common.service;

import com.ai.aso.common.db.model.DataRec;

import java.util.List;
import java.util.Map;

/**
 * 客户出账管理
 * <p>description:</p>
 *
 * @author lw
 * @2017/5/4
 */
public interface OutBillService {

    /**
     * 按客户分组
     * @param billBatch
     * @return
     */
    Map<String,List<DataRec>> groupingBill(String billBatch);
    /**
     * 获取出账批次
     *
     * @return
     */
    String findNewBillBatch();
    /**
     * 锁定本次出账的充值记录
     * @param contId
     * @param billBatch
     * @return
     */
    int lockBillDataRec(String contId, String billBatch);
    /**
     * 抽取本次出账成功充值记录，并进行计费摊分处理
     * @param contId
     * @param billBatch
     */
    void billingRec(String contId, String billBatch);
    /**
     * 更新出账批次状态
     * @param contId
     * @param billBatch
     */
    void completeBillState(String contId, String billBatch);

}
