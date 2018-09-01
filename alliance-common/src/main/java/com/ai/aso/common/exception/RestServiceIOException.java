package com.ai.aso.common.exception;

import com.ai.aso.base.exception.BusinessException;
import com.ai.aso.base.exception.ExInfo;

import java.io.Serializable;

public class RestServiceIOException extends BusinessException implements Serializable{

    private static final long serialVersionUID = 455457580766907084L;

    public RestServiceIOException() {
        super(BizExInfoEnum.SYS_GLOBAL_ERROR_HTTPCLIENT_RESP);
    }

    public RestServiceIOException(ExInfo exInfo) {
        super(exInfo);
    }
}
