package com.ai.aso.common.exception;

import com.ai.aso.base.exception.BusinessException;
import com.ai.aso.base.exception.ExInfo;

/**
 * 客户已经生效
 * *
 */
public class CustValidedException extends BusinessException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7782111598979714753L;

	public CustValidedException() {
		super(BizExInfoEnum.CUST_VALID_ERROR);
	}

	public CustValidedException(ExInfo exInfo) {
		super(exInfo);
	}
}
