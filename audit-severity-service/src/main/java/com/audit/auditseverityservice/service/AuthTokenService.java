package com.audit.auditseverityservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.audit.auditseverityservice.feignclient.AuthClient;
import com.audit.auditseverityservice.feignclient.JwtResponse;

@Service
public class AuthTokenService {
	@Autowired
	private AuthClient authClient;
	static boolean isValid; 
	
	public boolean checkTokenValidity(String token) {
    
		if(authClient.getValidity(token))
		{
			isValid=true;
		}
		else {
			isValid=false;
			
		}
		return isValid;
		
		

	}
}
