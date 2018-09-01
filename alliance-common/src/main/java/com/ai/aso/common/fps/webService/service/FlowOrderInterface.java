package com.ai.aso.common.fps.webService.service;

import com.ai.aso.common.fps.webService.model.FlowOrder;
import com.ai.aso.common.fps.webService.model.FlowOrderResult;
import com.ai.aso.common.fps.webService.model.FlowOrderStatus;
import com.ai.aso.common.fps.webService.model.FlowOrderStatusResult;

/**
 * 省集约平台充值接口
 */
public interface FlowOrderInterface {

    /**
     * 充值接口：根据充值信息调用省集约接口
     * @param fo
     * @return
     */
    FlowOrderResult flowOrder(FlowOrder fo);

    /**
     * 流量包订单状态查询接口
     * @param status
     * @return
     */
    FlowOrderStatusResult flowOrderStatus(FlowOrderStatus status);
}
