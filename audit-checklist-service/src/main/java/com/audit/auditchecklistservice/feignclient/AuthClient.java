package com.audit.auditchecklistservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "auth-service")
public interface AuthClient {

	@GetMapping(value = "/validate")
	public boolean getValidity(@RequestHeader("Authorization") String token);

}
