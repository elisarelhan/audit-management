package com.audit.auditseverityservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.audit.auditseverityservice.entity.AuditRequest;
import com.audit.auditseverityservice.entity.AuditResponse;
import com.audit.auditseverityservice.service.AuthTokenService;
import com.audit.auditseverityservice.service.SeverityServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/audit-severity")
public class SeverityController {

	@Autowired
	private SeverityServiceImpl severityService;
	@Autowired
	private AuthTokenService tokenService;

	final String tokenExpired = "the token is expired and not valid anymore";

	AuditResponse response = new AuditResponse();

//	private static final Logger logger = LoggerFactory.getLogger(SeverityController.class);

	@PostMapping("/ProjectExecutionStatus")
	public ResponseEntity<?> saveExecutionStatus(@RequestHeader(name = "Authorization", required = true) String token,
			@RequestBody AuditRequest request) {

		log.debug("Auditrequest", request);
		if (tokenService.checkTokenValidity(token)) {
			severityService.save(request);
			int quesNo = request.getAuditDetails().getAuditQuestions();
			if (quesNo <= 3) {
				response.setProjectExecStatus("GREEN");
				response.setActionDuration("No action needed");
				response.setResponseId(response.getResponseId() + 1);
			} else {
				response.setProjectExecStatus("RED");
				response.setActionDuration("Action to be taken in 2 weeks");
				response.setResponseId(response.getResponseId() + 1);
			}
//		logger.info(response.getProjectExecutionStatus());
//		logger.info(response.getRemedialActionDuration());
//		logger.info(Integer.toString(response.getResponseId()));

			severityService.saveResponse(response);
			return new ResponseEntity<AuditResponse>(response, HttpStatus.OK);

		} else {
			log.error("token expired");
			return new ResponseEntity<String>(tokenExpired, HttpStatus.FORBIDDEN);
		}

	}

}
