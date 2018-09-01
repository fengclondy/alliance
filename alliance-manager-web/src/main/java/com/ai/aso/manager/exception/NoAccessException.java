package com.ai.aso.manager.exception;

import com.ai.aso.base.exception.BaseException;

public class NoAccessException extends BaseException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6496283009928329951L;

	public NoAccessException() {
		super(OperationExInfoEnum.SYS_IP_LIMIT_HOST);
	}
	
}
