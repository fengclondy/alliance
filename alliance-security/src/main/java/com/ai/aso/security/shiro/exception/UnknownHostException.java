package com.ai.aso.security.shiro.exception;

import org.apache.shiro.authc.AuthenticationException;

public class UnknownHostException extends AuthenticationException {

	private static final long serialVersionUID = 1L;

	public UnknownHostException() {
		super();
	}

	public UnknownHostException(String message) {
		super(message);
	}

	public UnknownHostException(Throwable cause) {
		super(cause);
	}

	public UnknownHostException(String message, Throwable cause) {
		super(message, cause);
	}
}
