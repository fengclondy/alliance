package com.ai.aso.common.fps.webService.service.impl;

import com.ai.aso.common.param.GlobalParamSet;
import com.ai.aso.base.utils.RandomUtil;
import com.ai.aso.common.constants.BizConstants;
import com.ai.aso.common.fps.webService.model.*;
import com.ai.aso.common.fps.webService.security.AuthManager;
import com.ai.aso.common.fps.webService.service.FlowOrderInterface;
import com.ai.aso.common.utils.HttpClientUtil;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlowOrderInterfaceImpl implements FlowOrderInterface{

    private static final Logger log = LoggerFactory.getLogger(FlowOrderInterfaceImpl.class);

    @Autowired
    private AuthManager authManager;

    @Override
    public FlowOrderResult flowOrder(FlowOrder fo) {
        String url = GlobalParamSet.getString(BizConstants.FPS_INTERFACE_URL_FLOWORDER);
        fo.setService_code(GlobalParamSet.getString(BizConstants.FPS_SERVICE_CODE));

        log.debug("入参数据:" + JSONObject.toJSONString(fo));
        Params params = authManager.authorization(JSONObject.toJSONString(fo.toString()));
        String reps = HttpClientUtil.post(url, params.toJSONString());
        log.debug("返回数据:" + reps);

        FlowOrderResult fr = JSONObject.parseObject(reps, FlowOrderResult.class);
        return fr;
    }

    @Override
    public FlowOrderStatusResult flowOrderStatus(FlowOrderStatus status) {
        String url = GlobalParamSet.getString(BizConstants.FPS_INTERFACE_URL_FLOWORDERSTATUSQUERY);
        log.debug("入参数据:" + JSONObject.toJSONString(status.toString()));
        Params params = authManager.authorization(JSONObject.toJSONString(status.toString()));
        String reps = HttpClientUtil.post(url, params.toJSONString());
        log.debug("返回数据:" + reps);
        FlowOrderStatusResult fr = JSONObject.parseObject(reps,FlowOrderStatusResult.class);
        return fr;
    }
}
