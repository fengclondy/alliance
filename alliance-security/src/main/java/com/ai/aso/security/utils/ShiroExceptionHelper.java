package com.ai.aso.security.utils;

import com.ai.aso.security.exception.SecurityExInfoEnum;

import java.util.HashMap;
import java.util.Map;
import com.ai.aso.security.exception.SecurityException;
public class ShiroExceptionHelper {

	public static final String AuthenticationException = "org.apache.shiro.authc.AuthenticationException";
	public static final String UnknownAccountException = "org.apache.shiro.authc.UnknownAccountException";
	public static final String DisabledAccountException = "org.apache.shiro.authc.DisabledAccountException";
	public static final String LockedAccountException = "org.apache.shiro.authc.LockedAccountException";
	public static final String UnknownHostException = "com.ai.aso.security.shiro.exception.UnknownHostException";
	public static final String IncorrectCredentialsException = "org.apache.shiro.authc.IncorrectCredentialsException";
	public static final String IncorrectVALIDATECodeException = "validate.error";
	public static final String IncorrectVALIDATESMSCodeException ="sms.validate.error";

	public static Map<String, SecurityException> exceptionMap;
	static {
		exceptionMap = new HashMap<String, SecurityException>();
		exceptionMap.put(AuthenticationException, new SecurityException(
				SecurityExInfoEnum.AUTHEN_ERROR));
		exceptionMap.put(UnknownAccountException, new SecurityException(
				SecurityExInfoEnum.AUTHEN_UNKNOWN_ACCOUNT));
		exceptionMap.put(DisabledAccountException, new SecurityException(
				SecurityExInfoEnum.AUTHEN_DISABLED_ACCOUNT));
		exceptionMap.put(LockedAccountException, new SecurityException(
				SecurityExInfoEnum.AUTHEN_LOCKED_ACCOUNT));
		exceptionMap.put(UnknownHostException, new SecurityException(
				SecurityExInfoEnum.AUTHEN_UNKNOWN_HOST));
		exceptionMap.put(IncorrectCredentialsException, new SecurityException(
				SecurityExInfoEnum.AUTHEN_PASSWORD_ERROR));
		exceptionMap.put(IncorrectVALIDATECodeException, new SecurityException(
				SecurityExInfoEnum.AUTHEN_VALIDATE_ERROR));
		exceptionMap.put(IncorrectVALIDATESMSCodeException, new SecurityException(
				SecurityExInfoEnum.AUTHEN_SMS_VALIDATE_ERROR));
	}

	public static SecurityException convert(String eName) {
		if (exceptionMap.containsKey(eName)) {
			return exceptionMap.get(eName);
		}
		return new SecurityException();
	}

}
