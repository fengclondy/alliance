package com.ai.aso.common.service;

import com.ai.aso.common.db.model.DataRec;

import java.util.List;
import java.util.Map;

/**
 * <p>description:</p>
 *出账管理对外服务
 * @author lw
 * @2017/5/8
 */
public interface OutBillInterfaceService {
    /**
     * 处理出账
     * @param contId
     * @param billBatch
     */
    void dealBill(String contId, String billBatch);

    /**
     * 客户出账
     */
    void outBill();
}
