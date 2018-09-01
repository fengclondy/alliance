package com.ai.aso.common.exception;

import com.ai.aso.base.exception.BusinessException;
import com.ai.aso.base.exception.ExInfo;
import com.ai.aso.base.exception.ExInfoEnum;

public class BizValidException extends BusinessException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7530650675779054199L;

	public BizValidException() {
		super(ExInfoEnum.SYS_GLOBAL_ERROR);
	}

	public BizValidException(ExInfo exInfo) {
		super(exInfo);
	}
}
