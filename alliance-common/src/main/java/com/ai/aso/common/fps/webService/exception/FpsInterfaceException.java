package com.ai.aso.common.fps.webService.exception;

import com.ai.aso.base.exception.BusinessException;
import com.ai.aso.base.exception.ExInfo;

public class FpsInterfaceException extends BusinessException{

    private static final long serialVersionUID = 7313799877857854758L;

    public FpsInterfaceException() {
        super(FpsExInfoEnum.SYS_GLOBAL_ERROR);
    }

    public FpsInterfaceException(ExInfo exInfo) {
        super(exInfo);
    }
}
