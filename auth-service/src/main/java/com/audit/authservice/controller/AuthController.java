package com.audit.authservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.audit.authservice.config.JwtTokenUtil;
import com.audit.authservice.entity.JwtRequest;
import com.audit.authservice.entity.JwtResponse;
import com.audit.authservice.entity.UserDTO;
import com.audit.authservice.exception.LoginException;
import com.audit.authservice.exception.UsernamePresentException;
import com.audit.authservice.service.AuthService;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@Slf4j
//@RequestMapping(value = "/auth-service")
public class AuthController {

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private AuthService userService;

	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest)
			throws Exception, LoginException {

		try {
			authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
			final UserDetails userDetails = userService.loadUserByUsername(authenticationRequest.getUsername());

			final String token = jwtTokenUtil.generateToken(userDetails);
			final long expirationDate = jwtTokenUtil.JWT_TOKEN_VALIDITY;
			return ResponseEntity.ok(new JwtResponse(token, expirationDate));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

		}

	}

//	@GetMapping("/checkUsername/{username}")
//	public String checkUsername(@PathVariable String username) {
////		try {
////			if (userService.getUsername(username)) {
////				throw new UsernamePresentException("Username already exists.");
////			} else {
////				return "Username not present";
////			}
////		} catch (UsernamePresentException e) {
////			return (e.getMessage());
////		}
//		UserDetails userDetails = userService.loadUserByUsername(username);
//		if (userDetails.getUsername() != null) {
//			return "Username exists";
//		} else {
//			return "nothing";
//		}
//	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDTO user) {
		try {

			userService.save(user);
			final UserDetails userDetails = userService.loadUserByUsername(user.getUsername());
			final String idToken = jwtTokenUtil.generateToken(userDetails);
			final long expirationDate = jwtTokenUtil.JWT_TOKEN_VALIDITY;

			return ResponseEntity.ok(new JwtResponse(idToken, expirationDate));

		} catch (UsernamePresentException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

		}

	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

	@GetMapping("/validate")
	public boolean getValidity(@RequestHeader("Authorization") String token) {
		if (token.contains("Bearer")) {
			token = token.replace("Bearer ", "");

		}

		log.debug("auth token", token);
		boolean isValid = false;

		if (!jwtTokenUtil.isTokenExpired(token)) {
			isValid = true;
		}
		return isValid;
	}

}