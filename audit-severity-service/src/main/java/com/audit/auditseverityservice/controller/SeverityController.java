package com.audit.auditseverityservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.audit.auditseverityservice.entity.AuditRequest;
import com.audit.auditseverityservice.entity.AuditResponse;
import com.audit.auditseverityservice.service.SeverityServiceImpl;

@RestController
public class SeverityController {

	@Autowired
	private SeverityServiceImpl severityService;

	AuditResponse response = new AuditResponse();
	
	private static final Logger logger = LoggerFactory.getLogger(SeverityController.class);

	@PostMapping("/ProjectExecutionStatus")
	public AuditResponse saveExecutionStatus(@RequestBody AuditRequest request) {
		severityService.save(request);
		
		int ques_no = request.getAuditDetails().getAuditQuestions();
		if (ques_no <= 3) {
			response.setProjectExecutionStatus("GREEN");
			response.setRemedialActionDuration("No action needed");
			response.setResponseId(response.getResponseId()+1);
		} else {
			response.setProjectExecutionStatus("RED");
			response.setRemedialActionDuration("Action to be taken in 2 weeks");
			response.setResponseId(response.getResponseId()+1);
		}
		logger.info(response.getProjectExecutionStatus());
		logger.info(response.getRemedialActionDuration());
		logger.info(Integer.toString(response.getResponseId()));

		
		severityService.saveResponse(response);
		return response;

	}

}
