package com.audit.auditchecklistservice.service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.audit.auditchecklistservice.entity.AuditChecklist;
import com.audit.auditchecklistservice.exception.AuditTypeException;
import com.audit.auditchecklistservice.repository.ChecklistRepository;

@Service
public class ChecklistServiceImpl implements ChecklistService {

	@Autowired
	private ChecklistRepository checklistrepo;

	static Set<String> questionList = new LinkedHashSet<>();
	static List<AuditChecklist> checklist = new ArrayList<>();

	@Override
	public Set<String> findQuestionList(String auditType) throws AuditTypeException {

		if ((auditType.equalsIgnoreCase("Internal") || auditType.equalsIgnoreCase("Other"))
				&& checklistrepo.findQuestionsByauditType(auditType).isEmpty()) {
			return null;
		} else if ((auditType.equalsIgnoreCase("Internal") || auditType.equalsIgnoreCase("Other"))
				&& !checklistrepo.findQuestionsByauditType(auditType).isEmpty()) {
			questionList.clear();
			checklist = checklistrepo.findQuestionsByauditType(auditType);
			for (AuditChecklist question : checklist) {
				questionList.add(question.getQuestions());
			}
			return questionList;
		} else {
			throw new AuditTypeException("Invalid audit type.");
		}

	}

}
