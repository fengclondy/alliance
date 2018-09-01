package com.ai.aso.base.exception;

public class ExInfo {

	private String code; // 错误码

	private String msg; // 页面提示

	private String tip; // 提示

	public ExInfo(String code, String msg, String tip) {
		this.code = code;
		this.msg = msg;
		this.tip = tip;
	}

	public static ExInfo create(String code, String msg, String tip) {
		return new ExInfo(code, msg, tip);
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public String getTip() {
		return tip;
	}

}
