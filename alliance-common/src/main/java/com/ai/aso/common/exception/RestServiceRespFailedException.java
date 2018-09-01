package com.ai.aso.common.exception;

import com.ai.aso.base.exception.BusinessException;
import com.ai.aso.base.exception.ExInfo;

import java.io.Serializable;

public class RestServiceRespFailedException extends BusinessException implements Serializable{

    private static final long serialVersionUID = 455457580766907084L;

    public RestServiceRespFailedException() {
        super(BizExInfoEnum.SYS_GLOBAL_ERROR_HTTPCLIENT_RESP);
    }

    public RestServiceRespFailedException(ExInfo exInfo) {
        super(exInfo);
    }
}
