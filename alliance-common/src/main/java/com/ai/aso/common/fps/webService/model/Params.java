package com.ai.aso.common.fps.webService.model;

import com.alibaba.fastjson.JSONObject;

public class Params {
    private String appId;
    private String param;
    private String sign;

    public Params(String appId, String param, String sign) {
        this.appId = appId;
        this.param = param;
        this.sign = sign;
    }

    public String toJSONString() {
        return JSONObject.toJSONString(this);
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
