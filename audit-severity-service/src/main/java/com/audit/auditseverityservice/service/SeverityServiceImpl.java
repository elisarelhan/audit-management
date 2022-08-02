package com.audit.auditseverityservice.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.audit.auditseverityservice.entity.AuditDetails;
import com.audit.auditseverityservice.entity.AuditRequest;
import com.audit.auditseverityservice.entity.AuditResponse;
import com.audit.auditseverityservice.repository.AuditDetailsRepository;
import com.audit.auditseverityservice.repository.RequestRepository;
import com.audit.auditseverityservice.repository.ResponseRepository;

@Service
public class SeverityServiceImpl implements SeverityService {

	@Autowired
	private RequestRepository requestRepo;

	@Autowired
	private ResponseRepository responseRepo;

	@Autowired
	private AuditDetailsRepository detailsRepo;

	AuditRequest request = new AuditRequest();
	AuditResponse response = new AuditResponse();
	private static final Logger logger = LoggerFactory.getLogger(SeverityServiceImpl.class);

	
	@Override
	public AuditRequest save(AuditRequest requestDetails) {
		// requestRepo.save(requestId, projectName, projectManagerName,
		// applicationOwnername, auditdetails);
		requestRepo.save(requestDetails);
		/*
		 * int ques_no = requestDetails.getAuditDetails().getAuditQuestions();
		 * 
		 * if (ques_no <= 3) { response.setProjectExecutionStatus("GREEN");
		 * response.setRemedialActionDuration("No action needed"); } else {
		 * response.setProjectExecutionStatus("RED");
		 * response.setRemedialActionDuration("Action to be taken in 2 weeks"); }
		 * logger.info(response.getProjectExecutionStatus());
		 * logger.info(response.getRemedialActionDuration());
		 * logger.info(Integer.toString(response.getResponseId()));
		 * 
		 * 
		 * responseRepo.save(responseId, response.getProjectExecutionStatus(),
		 * response.getRemedialActionDuration());
		 */

		return requestDetails;
	}
	@Override
	public AuditResponse saveResponse(AuditResponse responseDetails)
	{
		responseRepo.save(responseDetails);
		return response;
	}
}
