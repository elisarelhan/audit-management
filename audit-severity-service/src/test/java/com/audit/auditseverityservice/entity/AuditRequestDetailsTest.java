package com.audit.auditseverityservice.entity;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class AuditRequestDetailsTest {

	private AuditRequest auditRequest;

	@BeforeEach
	public void setup() {
		auditRequest = new AuditRequest();
	}

	@Test
	public void testAuditRequestDetailsAllConstructor() {
		AuditDetails details = new AuditDetails();
		AuditRequest auditRequestDetails = new AuditRequest(2, "sss", "sss", "sss", details);
		assertEquals(2, auditRequestDetails.getRequestId());

	}

	@Test
	public void testSetGetAuditDetails() {
		AuditDetails auditDetails = new AuditDetails(2, "Internal", null, 4);
		auditRequest.setAuditDetails(auditDetails);
		assertEquals(auditDetails, auditRequest.getAuditDetails());
	}

	@Test
	public void testSetGetRequestId() {
		auditRequest.setRequestId(2);
		assertEquals(2, auditRequest.getRequestId());
	}

	@Test
	public void testGetSetProjectName() {
		auditRequest.setProjectName("Name1");
		assertEquals("Name1", auditRequest.getProjectName());
	}

	@Test
	public void testGetSetProjectManagerName() {
		auditRequest.setPrjManager("Name2");
		assertEquals("Name2", auditRequest.getPrjManager());
	}

	@Test
	public void testGetSetOwnerName() {
		auditRequest.setAppOwner("Name3");
		assertEquals("Name3", auditRequest.getAppOwner());
	}

	@Test
	public void testToString() {

		AuditDetails details = new AuditDetails(1, "int", null, 5);
		String expected = "AuditRequest(requestId=1, projectName=hi, prjManager=man, appOwner=me, auditDetails=AuditDetails(auditId=1, auditType=int, auditDate=null, auditQuestions=5))";
		auditRequest.setRequestId(1);
		auditRequest.setProjectName("hi");
		auditRequest.setPrjManager("man");
		auditRequest.setAppOwner("me");
		auditRequest.setAuditDetails(details);
		assertEquals(expected, auditRequest.toString());

	}

}
