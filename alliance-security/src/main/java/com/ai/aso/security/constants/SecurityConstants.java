package com.ai.aso.security.constants;

import ch.qos.logback.core.net.SyslogConstants;

public interface SecurityConstants  {

	final short LOGIN_ACCT_ENABLED = 1; // 在用
	final short LOGIN_ACCT_LOCKED = 2;// 锁定
	final short LOGIN_ACCT_DISABLED = 0; // 禁用
	
	// KEY
	final String LOGIN_ERROR_KEY = "shiroLoginFailure"; // FailureKeyAttribute

}
