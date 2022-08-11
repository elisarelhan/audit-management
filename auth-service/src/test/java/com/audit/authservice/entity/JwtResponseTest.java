package com.audit.authservice.entity;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class JwtResponseTest {

	@Mock
	JwtResponse authResponse = new JwtResponse();

	@Test
	public void testAuthResponseConstructor() {

		JwtResponse response = new JwtResponse("token", 120L);
		assertEquals("token", response.getToken());
		assertEquals(120L, (long) response.getExpiresIn());
	}
}
