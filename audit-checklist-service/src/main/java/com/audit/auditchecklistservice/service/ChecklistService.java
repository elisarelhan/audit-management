package com.audit.auditchecklistservice.service;

import java.util.Set;

import com.audit.auditchecklistservice.exception.AuditTypeException;

public interface ChecklistService {

	Set<String> findQuestionList(String auditType) throws AuditTypeException;

}
