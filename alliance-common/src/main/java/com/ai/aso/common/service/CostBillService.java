package com.ai.aso.common.service;

import java.util.List;

/**
 * <p>description:</p>
 *入賬管理
 * @author lw
 * @2017/5/8
 */
public interface CostBillService {

    void dealBill(String billMonth, String contId, String[] billBatch);
    /**
     * 统计入账数据
     *
     * @param billMonth 入账账期
     * @param contId    合同
     * @param billBatch 出账批次数组
     */
    int costBillEntry(String billMonth, String contId, String[] billBatch);

    /**
     * 收入摊分
     *
     * @param billMonth 入账账期
     * @param contId    合同
     * @param billBatch 出账批次数组
     */
    int repartitionBill(String billMonth, String contId, String[] billBatch);
    /**
     * 锁定入账
     * @param billIdList
     * @param billBatch
     * @return
     */
    int lockInbill(List<Long> billIdList);
    
    
    /**
     * 入账失败解锁
     * @param billIdList
     * @param billBatch
     * @return
     */
    int deblockingBill(List<Long> billIdList);
}
