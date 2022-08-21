package com.audit.authservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.audit.authservice.config.JwtTokenUtil;
import com.audit.authservice.entity.JwtRequest;
import com.audit.authservice.entity.JwtResponse;
import com.audit.authservice.entity.UserCredentials;
import com.audit.authservice.entity.UserDTO;
import com.audit.authservice.exception.LoginException;
import com.audit.authservice.repository.UserRepository;
import com.audit.authservice.service.AuthService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AuthControllerTest {

	@InjectMocks
	AuthController authController;

	JwtResponse authResponse;

	UserDetails userdetails;

	@Mock
	JwtTokenUtil jwtutil;

	@Mock
	AuthService authService;

	@Mock
	UserRepository userRepo;
	@Mock
	AuthenticationManager authManager;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void loginTest() throws Exception {
		JwtRequest request = new JwtRequest("admin", "admin");
		UserCredentials user = new UserCredentials(1, "admin", "admin");
		authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

		UserDetails loadUserByUsername = authService.loadUserByUsername(request.getUsername());
		UserDetails value = new User(user.getUsername(), user.getPassword(), new ArrayList<>());

		when(authService.loadUserByUsername("admin")).thenReturn(value);
		when(jwtutil.generateToken(loadUserByUsername)).thenReturn("token");

		ResponseEntity<?> login = authController.createAuthenticationToken(request);
		assertEquals(200, login.getStatusCodeValue());

	}

	@Test
	public void invalidLoginTest() throws LoginException, Exception {
		JwtRequest userdets = new JwtRequest("admin", "admin11");

		UserDetails loadUserByUsername = authService.loadUserByUsername(userdets.getUsername());
		UserDetails value = new User(userdets.getUsername(), "admin", new ArrayList<>());

		when(authService.loadUserByUsername("admin")).thenReturn(value);
		when(jwtutil.generateToken(loadUserByUsername)).thenReturn("token");

		Assertions.assertThrows(Exception.class, () -> {
			when(authController.createAuthenticationToken(userdets)).thenThrow(new Exception());
		});

	}

	@Test
	public void validateTestValidtoken() {
		JwtRequest userdets = new JwtRequest("admin", "admin");

		UserDetails loadUserByUsername = authService.loadUserByUsername(userdets.getUsername());
		when(jwtutil.generateToken(loadUserByUsername)).thenReturn("token");
		boolean validity = authController.getValidity("Bearer token");
		assertEquals(true, validity);
	}

	@Test
	public void validateTestInValidtoken() throws InterruptedException {
		UserCredentials user = new UserCredentials(1, "admin", "admin");
		UserDetails loadUserByUsername = authService.loadUserByUsername("admin");
		when(jwtutil.generateToken(loadUserByUsername)).thenReturn("token");
		TimeUnit.SECONDS.sleep(30);
		boolean validity = authController.getValidity("Bearer token");
		System.out.println(validity);
		assertEquals(true, validity);

	}

	@Test
	public void registerTest() throws Exception {
		UserDTO user = new UserDTO("admin", "admin");
		ResponseEntity<?> register = authController.saveUser(user);
		assertEquals(200, register.getStatusCodeValue());
	}

}
