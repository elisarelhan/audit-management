package com.audit.auditchecklistservice.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.audit.auditchecklistservice.feignclient.AuthClient;
import com.audit.auditchecklistservice.feignclient.JwtResponse;
import com.audit.auditchecklistservice.service.AuthTokenService;;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
public class AuthTokenServiceTest {

	@InjectMocks
	AuthTokenService tokenService;
	@Mock
	AuthClient authClient;

	@Mock
	JwtResponse authResponse;

	@Mock
	ResponseEntity<JwtResponse> entity;

	@Test
	public void testCheckTokenValidityWhenTokenIsValid() {

		entity = new ResponseEntity<JwtResponse>(new JwtResponse(null, (long) 120), HttpStatus.OK);
		when(authClient.getValidity("token")).thenReturn(true);

		assertEquals(true, tokenService.checkTokenValidity("token"));

	}

	@Test
	public void testCheckTokenValidityWhenTokenIsInvalid() {

		entity = new ResponseEntity<JwtResponse>(new JwtResponse(null, null), HttpStatus.OK);
		when(authClient.getValidity("token")).thenReturn(false);

		assertEquals(false, tokenService.checkTokenValidity("token"));

	}

	@Test
	public void testCheckTokenValidityWhenTokenIsnull() {

		when(authClient.getValidity(null)).thenReturn(false);

		assertEquals(false, tokenService.checkTokenValidity(null));

	}

}
