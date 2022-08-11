package com.audit.authservice.exceptions;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.audit.authservice.exception.ErrorHandler;
import com.audit.authservice.exception.TokenException;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
public class ErrorHandlerTest {

	@InjectMocks
	ErrorHandler handler;

	@Mock
	Environment env;

	@Test
	public void contextLoads() {
		assertNotNull(handler);
	}

	@Test
	public void testhandelTokenExceptionmsgThrowable() {

		assertNotNull(handler.handleTokenNotFoundexception(new TokenException("msg")));

	}

	@Test
	public void testhandelUserExceptionmsgThrowable() {

		assertNotNull(handler.handleUserNotFoundexception(new UsernameNotFoundException("msg")));

	}

}
