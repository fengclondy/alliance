package com.ai.aso.manager.exception;

import com.ai.aso.base.exception.BusinessException;
import com.ai.aso.base.exception.ExInfo;

public class ValidateException extends BusinessException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2732832653081756773L;
	
	public ValidateException(ExInfo exInfo){
		super(exInfo);
	}
}
