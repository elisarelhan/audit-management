package com.audit.authservice.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class ErrorHandler extends ResponseEntityExceptionHandler {

//	@ExceptionHandler(LoginException.class)
//	public ResponseEntity<CustomErrorResponse> handleIdNotFoundexception(LoginException ex) {
//		log.debug("LoginFailedException", ex);
//		CustomErrorResponse response = new CustomErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND,
//				"Invalid Credentials", ex.getMessage());
//		return new ResponseEntity<CustomErrorResponse>(response, HttpStatus.NOT_FOUND);
//	}

	@ExceptionHandler(TokenException.class)
	public ResponseEntity<CustomErrorResponse> handleTokenNotFoundexception(TokenException ex) {
		log.debug("TokenExpiredException", ex);
		CustomErrorResponse response = new CustomErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND,
				"the token is expired and not valid anymore", ex.getMessage());

		return new ResponseEntity<CustomErrorResponse>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> handleUserNotFoundexception(UsernameNotFoundException ex) {
		CustomErrorResponse response = new CustomErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND,
				"Invalid Credentials", ex.getMessage());
		return new ResponseEntity<CustomErrorResponse>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BadCredentialsException.class)
	protected ResponseEntity<Object> handleGenericExceptions(BadCredentialsException ex, WebRequest request) {
		log.warn(ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	}

	@ExceptionHandler(UsernamePresentException.class)
	protected ResponseEntity<CustomErrorResponse> handleGenericExceptions(UsernamePresentException ex) {
		log.warn(ex.getMessage());
		CustomErrorResponse response = new CustomErrorResponse(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR,
				"Invalid Credentials", ex.getMessage());
		return new ResponseEntity<CustomErrorResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}