package com.audit.auditchecklistservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AuditChecklistServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuditChecklistServiceApplication.class, args);
	}

}
