package com.ai.aso.common.fps.webService.exception;

import com.ai.aso.base.exception.BusinessException;
import com.ai.aso.base.exception.ExInfo;

public class NoAuthenticationException extends BusinessException{

    private static final long serialVersionUID = 7313799877857854758L;

    public NoAuthenticationException() {
        super(FpsExInfoEnum.No_ACCESS_ERROR);
    }

    public NoAuthenticationException(ExInfo exInfo) {
        super(exInfo);
    }
}
