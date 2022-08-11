package com.audit.authservice.exceptions;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.audit.authservice.exception.LoginException;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
public class LoginExceptionTest {

	@Test
	public void testInvalidAuthorizationException() {

		LoginException loginFailedException = new LoginException("Invalid Credentials");
		assertNotNull(loginFailedException);

	}

}
