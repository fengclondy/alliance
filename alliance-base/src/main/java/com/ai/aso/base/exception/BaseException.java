package com.ai.aso.base.exception;

/**
 * 文件名：BaseException.java<br>
 * 项目自定义根异常类<br>
 * 项目所有自定义异常均需直接或间接继承根异常类<br>
 * 
 * @author yusx
 * @version 1.0
 * @since JDK 1.6
 */
public class BaseException extends RuntimeException {

	private static final long serialVersionUID = 3023656862495659395L;

	private ExInfo exInfo;

	/**
	 * 默认设置系统全局异常
	 */
	public BaseException() {
		this.exInfo = ExInfoEnum.SYS_GLOBAL_ERROR;
	}

	public BaseException(ExInfo exInfo) {
		this.exInfo = exInfo;
	}

	/**
	 * 获取错误码
	 * 
	 * @return code 错误码
	 */
	public String getCode() {
		return exInfo.getCode();
	}

	/**
	 * 错误错误提示，用于页面显示
	 * 
	 * @return tip 页面提示信息
	 */
	public String getTip() {
		return exInfo.getTip();
	}

	@Override
	public String getMessage() {
		return exInfo.getMsg();
	}

	@SuppressWarnings("unused")
	private BaseException(String message) {
		super(message);
	}

	@SuppressWarnings("unused")
	private BaseException(Throwable cause) {
		super(cause);
	}

	@SuppressWarnings("unused")
	private BaseException(String message, Throwable cause) {
		super(message, cause);
	}

}
