package com.audit.auditchecklistservice.service;

import java.util.List;

import com.audit.auditchecklistservice.entity.AuditChecklist;

public interface ChecklistService {
	
	List<String> findQuestionList(String auditType);

}
