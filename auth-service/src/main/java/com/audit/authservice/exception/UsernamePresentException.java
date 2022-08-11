package com.audit.authservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Username is already present.")
public class UsernamePresentException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UsernamePresentException(String message) {
		super(message);
	}

}
