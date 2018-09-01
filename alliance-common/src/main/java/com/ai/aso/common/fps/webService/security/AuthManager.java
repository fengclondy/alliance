package com.ai.aso.common.fps.webService.security;

import com.ai.aso.common.param.GlobalParamSet;
import com.ai.aso.base.utils.StringUtil;
import com.ai.aso.common.constants.BizConstants;
import com.ai.aso.common.fps.webService.exception.NoAuthenticationException;
import com.ai.aso.common.fps.webService.model.Params;
import com.ai.aso.common.fps.webService.security.service.SecurityService;
import com.ai.aso.common.utils.MD5utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthManager {

    @Autowired
    private SecurityService XXTEASecurityService;

    /**
     * 入参认证
     * @return
     */
    public String authentication(String appId, String param, String sign) {
        if (StringUtil.isEmpty(appId)) {
            throw new NoAuthenticationException();
        }
        if (StringUtil.isEmpty(sign)) {
            throw new NoAuthenticationException();
        }

        String in = sign(appId, param);
        if (sign.equals(in)) {
            return XXTEASecurityService.decrypt(param);
        } else {
            throw new NoAuthenticationException();
        }
    }

    /**
     * 授权
     * @param param
     * @return
     */
    public Params authorization(String param) {
        String out = encryptParam(param);
        return new Params(GlobalParamSet.getString(BizConstants.FPS_SECURITY_APP_ID), out, sign(out));
    }

    public String encryptParam(String param) {
        return XXTEASecurityService.encrypt(param);
    }

    public static String sign(String param) {
        String appId = GlobalParamSet.getString(BizConstants.FPS_SECURITY_APP_ID);
        String appSecret = GlobalParamSet.getString(BizConstants.FPS_SECURITY_APP_SECRET);
        return MD5utils.string2MD5(appId + param + appSecret);
    }

    public static String sign(String appId, String param) {
        String appSecret = GlobalParamSet.getString(BizConstants.FPS_SECURITY_APP_SECRET);
        return MD5utils.string2MD5(appId + param + appSecret);
    }

    public static void main(String[] args) {
    }
}
