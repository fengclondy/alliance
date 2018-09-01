package com.ai.aso.security.exception;

import com.ai.aso.base.exception.BusinessException;
import com.ai.aso.base.exception.ExInfo;

public class SecurityException extends BusinessException {

	private static final long serialVersionUID = 6093285649802901916L;

	public SecurityException() {
		super(SecurityExInfoEnum.SECURITY_ERROR);
	}

	public SecurityException(ExInfo exInfo) {
		super(exInfo);
	}
}
