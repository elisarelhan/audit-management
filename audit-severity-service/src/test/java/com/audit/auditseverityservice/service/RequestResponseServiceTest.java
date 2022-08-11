package com.audit.auditseverityservice.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.audit.auditseverityservice.entity.AuditDetails;
import com.audit.auditseverityservice.entity.AuditRequest;
import com.audit.auditseverityservice.entity.AuditResponse;
import com.audit.auditseverityservice.repository.RequestRepository;
import com.audit.auditseverityservice.repository.ResponseRepository;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
public class RequestResponseServiceTest {

	@InjectMocks
	SeverityServiceImpl requestResponseService;

	@Mock
	SeverityServiceImpl req1;

	@Mock
	ResponseRepository responseRepository;

	@Mock
	RequestRepository requestRepository;

//	@Test
//	public void saveResponseTest() {
//
//		AuditResponse response = new AuditResponse(1, "GREEN", "No action required");
//
//		AuditResponse response1 = response;
//		when(responseRepository.save(response1)).thenReturn(response1);
//		assertEquals(response1, requestResponseService.saveResponse(response));
//
//	}

	@Test
	public void saveRequestTest() {

		AuditDetails details = new AuditDetails();
		AuditRequest request = new AuditRequest(1, " projectName", "managerName", "ownerName", details);
		AuditRequest request1 = request;
		AuditResponse response = new AuditResponse(1, "GREEN", "No action required");
		when(responseRepository.save(response)).thenReturn(response);
		when(requestRepository.save(request1)).thenReturn(request1);
		assertEquals(request1, requestResponseService.save(request));

	}

}
