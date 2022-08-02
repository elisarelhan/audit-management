package com.audit.auditseverityservice.service;

import java.util.List;

import com.audit.auditseverityservice.entity.AuditDetails;
import com.audit.auditseverityservice.entity.AuditRequest;
import com.audit.auditseverityservice.entity.AuditResponse;

public interface SeverityService {

	// void save(int requestId, String projectName, String projectManagerName,String applicationOwnername, AuditDetails auditdetails);

	//List<AuditResponse> findAll(int responseId);

	AuditRequest save(AuditRequest requestDetails);

	AuditResponse saveResponse(AuditResponse responseDetails);

}
