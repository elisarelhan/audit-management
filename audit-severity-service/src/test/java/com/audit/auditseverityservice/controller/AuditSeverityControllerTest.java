package com.audit.auditseverityservice.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.audit.auditseverityservice.entity.AuditDetails;
import com.audit.auditseverityservice.entity.AuditRequest;
import com.audit.auditseverityservice.feignclient.AuthClient;
import com.audit.auditseverityservice.service.AuthTokenService;
import com.audit.auditseverityservice.service.SeverityServiceImpl;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
public class AuditSeverityControllerTest {

	@Mock
	private SeverityServiceImpl service;

	@Mock
	AuthClient authClient;

	@Mock
	AuditRequest auditRequest;

	@Mock
	AuthTokenService tokenService;

	@InjectMocks
	SeverityController severityController;

	@Test
	public void contextLoad() {
		assertNotNull(severityController);
	}

	@Test
	public void testExecutionStatus1() {

		Date date = null;
		when(tokenService.checkTokenValidity("token")).thenReturn(true);
		AuditRequest request = new AuditRequest();
		request.setPrjManager("manager");
		request.setAppOwner("owner");
		request.setProjectName("project");
		AuditDetails details = new AuditDetails();
		details.setAuditDate(date);
		details.setAuditType("Internal");
		details.setAuditQuestions(2);
		request.setAuditDetails(details);
		assertEquals(HttpStatus.OK, severityController.saveExecutionStatus("token", request).getStatusCode());
	}

	@Test
	public void testExecutionStatus2() {

		Date date = null;
		when(tokenService.checkTokenValidity("token")).thenReturn(true);
		AuditRequest request = new AuditRequest();
		request.setPrjManager("manager");
		request.setAppOwner("owner");
		request.setProjectName("project");
		AuditDetails details = new AuditDetails();
		details.setAuditDate(date);
		details.setAuditType("Internal");
		details.setAuditQuestions(4);
		request.setAuditDetails(details);
		assertEquals(HttpStatus.OK, severityController.saveExecutionStatus("token", request).getStatusCode());
	}

//	@Test
//	public void testExecutionStatus3() {
//
//		when(tokenService.checkTokenValidity("token")).thenReturn(true);
//		AuditRequestDetails request = new AuditRequestDetails();
//		request.setManagerName("manager");
//		request.setOwnerName("owner");
//		request.setProjectName("project");
//		AuditDetails details = new AuditDetails();
//		details.setAuditDate(new Date());
//		details.setAuditType("Other");
//		details.setQuestionResponse(2);
//		request.setAuditDetails(details);
//		assertEquals(HttpStatus.OK, severityController.getExceutionStatus("token", request).getStatusCode());
//	}
//
//	@Test
//	public void testExecutionStatus4() {
//
//		when(tokenService.checkTokenValidity("token")).thenReturn(true);
//		AuditRequestDetails request = new AuditRequestDetails();
//		request.setManagerName("manager");
//		request.setOwnerName("owner");
//		request.setProjectName("project");
//		AuditDetails details = new AuditDetails();
//		details.setAuditDate(new Date());
//		details.setAuditType("Other");
//		details.setQuestionResponse(4);
//		request.setAuditDetails(details);
//		assertEquals(HttpStatus.OK, severityController.getExceutionStatus("token", request).getStatusCode());
//	}

	@Test
	public void testAuditSeverityTokenFails() {
		Date date = null;
		when(tokenService.checkTokenValidity("token")).thenReturn(false);
		AuditRequest request = new AuditRequest();
		request.setPrjManager("manager");
		request.setAppOwner("owner");
		request.setProjectName("project");
		AuditDetails details = new AuditDetails();
		details.setAuditDate(date);
		details.setAuditType("Internal");
		details.setAuditQuestions(4);
		request.setAuditDetails(details);
		assertEquals(HttpStatus.FORBIDDEN, severityController.saveExecutionStatus("token", request).getStatusCode());
	}

}
