package com.ai.aso.manager.exception;

import com.ai.aso.base.exception.BaseException;

/**
 * 未配置异常
 * @author wuqiang6
 *
 */
public class UnsettledException extends BaseException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3490096823497065732L;

	public UnsettledException() {
		super(OperationExInfoEnum.SYS_IP_LIMIT_UNSETTING);
	}
}
