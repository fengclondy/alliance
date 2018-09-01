package com.ai.aso.base.exception;

/**
 * 文件名：BusinessException.java<br>
 * 系统中预定义的逻辑错误，使用此异常的自定义子异常进行错误传递<br>
 * 项目中所有的错误传递可包装为此异常类的子类异常<br>
 * 利用MVC的统一异常处理在错误页面进行展示。<br>
 * 
 * @author yusx
 * @version 1.0
 * @since JDK 1.6
 */
public class BusinessException extends BaseException {

	private static final long serialVersionUID = -1515859387411014288L;

	public BusinessException() {
		super(ExInfoEnum.SYS_GLOBAL_ERROR);
	}

	public BusinessException(ExInfo exInfo) {
		super(exInfo);
	}

}
