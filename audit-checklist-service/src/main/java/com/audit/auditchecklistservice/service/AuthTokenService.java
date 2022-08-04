package com.audit.auditchecklistservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.audit.auditchecklistservice.feignclient.AuthClient;



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
