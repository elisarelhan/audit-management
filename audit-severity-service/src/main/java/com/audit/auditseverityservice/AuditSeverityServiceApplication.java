package com.audit.auditseverityservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AuditSeverityServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuditSeverityServiceApplication.class, args);
	}

}
