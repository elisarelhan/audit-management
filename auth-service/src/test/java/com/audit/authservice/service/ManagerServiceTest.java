package com.audit.authservice.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.audit.authservice.entity.JwtRequest;
import com.audit.authservice.entity.UserCredentials;
import com.audit.authservice.repository.UserRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ManagerServiceTest {

	UserDetails userdetails;

	@InjectMocks
	AuthService authService;

	@Mock
	UserRepository userRepo;

	@Test
	public void loadUserByUsernameTest() {
		JwtRequest user1 = new JwtRequest("audit1", "password1");
		UserCredentials user = new UserCredentials(1, "audit1", "password1");
		when(userRepo.findByUsername("audit1")).thenReturn(user);
		UserDetails loadUserByUsername2 = authService.loadUserByUsername("audit1");
		assertEquals(user1.getUsername(), loadUserByUsername2.getUsername());
	}

	@Test
	public void loadUserByUsernameExceptionTest() throws UsernameNotFoundException {
		JwtRequest user1 = new JwtRequest("audit1", "password1");
		Optional.of(user1);
		UsernameNotFoundException thrown = Assertions.assertThrows(UsernameNotFoundException.class, () -> {
			authService.loadUserByUsername("test");
		});
		Assertions.assertEquals("User not found with username: test", thrown.getMessage());
	}

}
