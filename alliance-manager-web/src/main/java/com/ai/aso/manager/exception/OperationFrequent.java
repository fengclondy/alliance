package com.ai.aso.manager.exception;

import com.ai.aso.base.exception.BaseException;

public class OperationFrequent extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -570991433347132004L;

	public OperationFrequent() {
		super(OperationExInfoEnum.SYS_IP_LIMIT_FREQUENT);
	}
}
