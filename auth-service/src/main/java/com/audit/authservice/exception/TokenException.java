package com.audit.authservice.exception;

import io.jsonwebtoken.ExpiredJwtException;

public class TokenException extends ExpiredJwtException {

	private static final long serialVersionUID = 1L;

	public TokenException(String message) {
		super(null, null, message);
	}
}
