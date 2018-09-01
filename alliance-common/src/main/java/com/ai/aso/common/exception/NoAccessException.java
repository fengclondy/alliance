package com.ai.aso.common.exception;

import com.ai.aso.base.exception.BusinessException;
import com.ai.aso.base.exception.ExInfo;

/**
 * 无效操作权限错误
 * @author wuqiang6
 *
 */
public class NoAccessException extends BusinessException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3007593146921385039L;

	public NoAccessException() {
		super(BizExInfoEnum.No_ACCESS_ERROR);
	}

	public NoAccessException(ExInfo exInfo) {
		super(exInfo);
	}
}
