package com.audit.auditseverityservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.audit.auditseverityservice.feignclient.AuthClient;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuthTokenService {
	@Autowired
	private AuthClient authClient;
	static boolean isValid;

	public boolean checkTokenValidity(String token) {

		log.debug("token", token);
		try {
			if (authClient.getValidity(token)) {
				isValid = true;
			} else {
				isValid = false;

			}
			return isValid;
		} catch (Exception e) {
			return false;
		}

	}
}
