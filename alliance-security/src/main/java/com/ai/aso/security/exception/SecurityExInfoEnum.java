package com.ai.aso.security.exception;

import com.ai.aso.base.exception.ExInfo;
import com.ai.aso.base.exception.ExInfoEnum;
import com.ai.aso.security.constants.SecurityResultCode;

public interface SecurityExInfoEnum extends ExInfoEnum {

	ExInfo SECURITY_ERROR = ExInfo.create(SecurityResultCode.SECURITY_ERROR,
			"安全异常", "未知安全异常");
	ExInfo AUTHEN_ERROR = ExInfo.create(SecurityResultCode.AUTHEN_ERROR,
			"用户鉴权错误", "用户名或密码错误！");
	ExInfo AUTHEN_UNKNOWN_ACCOUNT = ExInfo.create(
			SecurityResultCode.AUTHEN_UNKNOWN_ACCOUNT, "账号不存在", "用户名或密码不存在！");
	ExInfo AUTHEN_DISABLED_ACCOUNT = ExInfo.create(
			SecurityResultCode.AUTHEN_DISABLED_ACCOUNT, "账号被禁用", "用户名或密码不存在！");
	ExInfo AUTHEN_LOCKED_ACCOUNT = ExInfo.create(
			SecurityResultCode.AUTHEN_LOCKED_ACCOUNT, "账号被锁定", "用户名或密码不存在！");
	ExInfo AUTHEN_UNKNOWN_HOST = ExInfo.create(
			SecurityResultCode.AUTHEN_UNKNOWN_HOST, "IP不在允许访问列表内", "身份信息验证错误！");
	ExInfo AUTHEN_PASSWORD_ERROR = ExInfo.create(
			SecurityResultCode.AUTHEN_PASSWORD_ERROR, "密码校验失败", "用户名或密码不存在！");
	ExInfo AUTHEN_VALIDATE_ERROR = ExInfo.create(
			SecurityResultCode.AUTHEN_VALIDATE_ERROR, "验证码校验失败", "验证码错误！");
	ExInfo AUTHEN_SMS_VALIDATE_ERROR = ExInfo.create(
			SecurityResultCode.AUTHEN_SMS_VALIDATE_ERROR, "短信验证码校验失败", "短信验证码错误！");
}
