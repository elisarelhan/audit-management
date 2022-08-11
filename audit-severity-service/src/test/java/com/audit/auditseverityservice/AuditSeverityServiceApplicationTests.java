package com.audit.auditseverityservice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.Generated;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class AuditSeverityServiceApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Generated
	public static void main(String[] args) {
		SpringApplication.run(AuditSeverityServiceApplicationTests.class, args);
	}

}
