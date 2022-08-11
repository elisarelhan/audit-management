package com.audit.auditseverityservice.entity;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class AuditResponseDetailsTest {

	private AuditResponse auditResponse;

	@BeforeEach
	public void setup() {
		auditResponse = new AuditResponse();
	}

	@Test
	public void testGetSetProjectExecutionStatus() {
		auditResponse.setProjectExecStatus("GREEN");
		assertEquals("GREEN", auditResponse.getProjectExecStatus());
	}

	@Test
	public void testGetSetRemedialActionDuration() {
		auditResponse.setActionDuration("None");
		assertEquals("None", auditResponse.getActionDuration());
	}

	@Test
	public void testGetResponseId() {
		auditResponse.setResponseId(5);
		assertEquals(5, auditResponse.getResponseId());
	}

	@Test
	public void testToString() {

		String expected = "AuditResponse(responseId=1, projectExecStatus=Red, actionDuration=action needed)";
		auditResponse.setResponseId(1);
		auditResponse.setProjectExecStatus("Red");
		auditResponse.setActionDuration("action needed");
		assertEquals(expected, auditResponse.toString());

	}

}
