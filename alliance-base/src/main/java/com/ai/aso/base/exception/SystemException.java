package com.ai.aso.base.exception;

/**
 * 文件名：SystemException.java<br>
 * 系统中非预定义的错误，利用MVC的统一包装为此异常在错误页面显示<br>
 * 
 * @author yusx
 * @version 1.0
 * @since JDK 1.6
 */
public class SystemException extends BaseException {

	private static final long serialVersionUID = 3534266117911580641L;

	public SystemException() {
		super(ExInfoEnum.SYS_GLOBAL_ERROR);
	}

	public SystemException(ExInfo exInfo) {
		super(exInfo);
	}

}
