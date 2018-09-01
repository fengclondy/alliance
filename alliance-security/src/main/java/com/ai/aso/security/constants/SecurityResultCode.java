package com.ai.aso.security.constants;

import com.ai.aso.base.constants.IResultCode;
import com.ai.aso.base.constants.ISystemCode;

public interface SecurityResultCode extends IResultCode {

	String SECURITY_ERROR = "F" + ISystemCode.MODEL_SECURITY_CODE
			+ ISystemCode.FUNC_PUBLIC + "0001"; // 未知安全异常

	// 认证功能编码
	String FUNC_AUTHEN = ISystemCode.MODEL_SECURITY_CODE
			+ ISystemCode.FUNC_SECURITY_AUTHEN;
	String AUTHEN_SUCCESS = FUNC_AUTHEN + "0001"; // 认证成功
	String AUTHEN_ERROR = "F" + FUNC_AUTHEN + "0010"; // 未知认证错误
	String AUTHEN_UNKNOWN_ACCOUNT = "F" + FUNC_AUTHEN + "0011"; // 账号不存在
	String AUTHEN_DISABLED_ACCOUNT = "F" + FUNC_AUTHEN + "0012"; // 账号被禁用
	String AUTHEN_LOCKED_ACCOUNT = "F" + FUNC_AUTHEN + "0013"; // 账号被锁定
	String AUTHEN_UNKNOWN_HOST = "F" + FUNC_AUTHEN + "0014"; // IP不在允许访问列表内
	String AUTHEN_PASSWORD_ERROR = "F" + FUNC_AUTHEN + "0015"; // 密码校验失败
	String AUTHEN_VALIDATE_ERROR = "F" + FUNC_AUTHEN + "0016";//验证码错误
	
	String AUTHEN_SMS_VALIDATE_ERROR="F" + FUNC_AUTHEN + "0017";//短信验证码错误
}