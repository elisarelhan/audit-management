package com.audit.auditchecklistservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.audit.auditchecklistservice.entity.AuditChecklist;
import com.audit.auditchecklistservice.service.ChecklistServiceImpl;



@RestController
public class ChecklistController {
	
	private static final Logger logger = LoggerFactory.getLogger(ChecklistController.class);
	@Autowired
	private ChecklistServiceImpl checklistService;
	
	@GetMapping("/AuditCheckListQuestions/{auditType}")
	public List<String> findChecklist(@PathVariable String auditType )
	{
		List<String> checklist=new ArrayList<>();
		
		checklist=checklistService.findQuestionList(auditType);
		return checklist;
	}
	

}
