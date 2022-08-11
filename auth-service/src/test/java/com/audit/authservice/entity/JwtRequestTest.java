package com.audit.authservice.entity;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class JwtRequestTest {

	JwtRequest auditManager = new JwtRequest();

	@Test
	public void testProjectManagerAllConstructor() {
		JwtRequest manager = new JwtRequest("audit1", "password1");
		assertEquals("audit1", manager.getUsername());

	}

	@Test
	public void testUserid() {

		auditManager.setUsername("audit1");
		assertEquals("audit1", auditManager.getUsername());

	}

	@Test
	public void testUserPassword() {
		auditManager.setPassword("audit1");
		assertEquals("audit1", auditManager.getPassword());
	}

}
