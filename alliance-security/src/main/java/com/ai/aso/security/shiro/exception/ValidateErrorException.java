package com.ai.aso.security.shiro.exception;

import org.apache.shiro.authc.AuthenticationException;

public class ValidateErrorException extends AuthenticationException {

	private static final long serialVersionUID = 1L;

	public ValidateErrorException() {
		super();
	}

	public ValidateErrorException(String message) {
		super(message);
	}

	public ValidateErrorException(Throwable cause) {
		super(cause);
	}

	public ValidateErrorException(String message, Throwable cause) {
		super(message, cause);
	}
}
