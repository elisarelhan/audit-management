package com.audit.auditchecklistservice.controller;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.audit.auditchecklistservice.exception.AuditTypeException;
import com.audit.auditchecklistservice.service.ChecklistServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/audit-checklist")
public class ChecklistController {

	@Autowired
	private ChecklistServiceImpl checklistService;
	@Autowired
	private com.audit.auditchecklistservice.service.AuthTokenService tokenService;

	final String tokenExpired = "The token is expired and not valid anymore.";

	@SuppressWarnings("rawtypes")
	@GetMapping("/AuditCheckListQuestions/{auditType}")
	public ResponseEntity<?> findChecklist(@RequestHeader(name = "Authorization", required = true) String token,
			@PathVariable String auditType) throws AuditTypeException {
		Set<String> checklist = new LinkedHashSet<>();
		if (tokenService.checkTokenValidity(token)) {

			checklist = checklistService.findQuestionList(auditType);

			return new ResponseEntity<Set>(checklist, HttpStatus.OK);

		} else {
			log.error("token expired");
			return new ResponseEntity<String>(tokenExpired, HttpStatus.FORBIDDEN);
		}
	}

}
