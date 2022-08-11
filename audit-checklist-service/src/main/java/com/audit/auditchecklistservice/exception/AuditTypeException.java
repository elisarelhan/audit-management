package com.audit.auditchecklistservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Invalid audit type")
public class AuditTypeException extends RuntimeException {
	public AuditTypeException(String message) {
		super(message);
	}
}
