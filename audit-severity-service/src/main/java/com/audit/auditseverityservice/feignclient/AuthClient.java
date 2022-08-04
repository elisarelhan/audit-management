package com.audit.auditseverityservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name="auth-service",url="localhost:8000")
public interface AuthClient {
	
	@GetMapping(value="/validate")
	public boolean getValidity(@RequestHeader("Authorization") String token);

}
