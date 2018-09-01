package com.ai.aso.common.service;

import java.util.List;
import java.util.Map;

/**
 * <p>description:</p>
 * 入账對外服務
 * @author lw
 * @2017/5/3
 */
public interface BillEntryService {
    /**
     * 获取待入账信息
     * @param billId
     * @return
     */
    Map<String,List<String>> censusBill(String[] billId);

    /**
     * 客户入账
     * @param map
     */
    void billEntry(Map<String, List<String>> map, List<Long> billIdList);
}
