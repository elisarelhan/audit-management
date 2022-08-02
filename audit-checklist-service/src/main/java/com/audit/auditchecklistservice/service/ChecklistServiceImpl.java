package com.audit.auditchecklistservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.audit.auditchecklistservice.entity.AuditChecklist;
import com.audit.auditchecklistservice.repository.ChecklistRepository;

@Service
public class ChecklistServiceImpl implements ChecklistService {

	@Autowired
	private ChecklistRepository checklistrepo;
	
	static List<String> questionList=new ArrayList<>();
	static List<AuditChecklist> checklist=new ArrayList<>();

	public List<String> findQuestionList(String auditType) {
		
		
		checklist=checklistrepo.findQuestionsByauditType(auditType);
		for(AuditChecklist question:checklist)
		{
			questionList.add(question.getQuestions());
		}
		return questionList;
	}

}
