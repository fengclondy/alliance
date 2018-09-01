package com.ai.aso.common.fps.webService.security.service;

public interface SecurityService {

    /**
     * 入参加密
     * @param plainParamsStr
     * @return
     */
    String encrypt(String plainParamsStr);

    /**
     * 入参解密
     * @param cipherParamsStr
     * @return
     */
    String decrypt(String cipherParamsStr);
}
