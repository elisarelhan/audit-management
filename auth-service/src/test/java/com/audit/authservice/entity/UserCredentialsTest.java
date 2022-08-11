package com.audit.authservice.entity;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
public class UserCredentialsTest {

	UserCredentials loginCredential = new UserCredentials();

	@Test
	public void testUserLoginCredentialAllConstructor() {
		UserCredentials credential = new UserCredentials(1, "audit1", "password1");
		assertEquals("audit1", credential.getUsername());
	}

	@Test
	public void testGetUid() {
		loginCredential.setUserId(1);
		assertEquals(1, loginCredential.getUserId());
	}

	@Test
	public void testGetUsername() {
		loginCredential.setUsername("me");
		assertEquals("me", loginCredential.getUsername());
	}

	@Test
	public void testUserPassword() {
		loginCredential.setPassword("audit1");
		assertEquals("audit1", loginCredential.getPassword());
	}

}
