package com.ai.aso.common.fps.webService.security.service.impl;

import com.ai.aso.common.param.GlobalParamSet;
import com.ai.aso.common.constants.BizConstants;
import com.ai.aso.common.fps.webService.security.service.SecurityService;
import com.ai.aso.common.utils.XXTEA;
import org.springframework.stereotype.Service;

@Service("XXTEASecurityService")
public class XXTEASecurityServiceImpl extends SecurityServiceImpl implements SecurityService{

    private String appSecret;

    @Override
    public String encrypt(String plainParamsStr) {
        appSecret = GlobalParamSet.getString(BizConstants.FPS_SECURITY_APP_SECRET);
        return XXTEA.encrypt(plainParamsStr, "UTF-8", appSecret);
    }

    @Override
    public String decrypt(String cipherParamsStr) {
        appSecret = GlobalParamSet.getString(BizConstants.FPS_SECURITY_APP_SECRET);
        return XXTEA.decrypt(cipherParamsStr, "UTF-8", appSecret);
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }
}
