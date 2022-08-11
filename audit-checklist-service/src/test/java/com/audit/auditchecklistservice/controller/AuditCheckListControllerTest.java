package com.audit.auditchecklistservice.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.audit.auditchecklistservice.exception.AuditTypeException;
import com.audit.auditchecklistservice.feignclient.AuthClient;
import com.audit.auditchecklistservice.repository.ChecklistRepository;
import com.audit.auditchecklistservice.service.AuthTokenService;
import com.audit.auditchecklistservice.service.ChecklistServiceImpl;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
@Slf4j
public class AuditCheckListControllerTest {

	@Mock
	AuthClient authClient;

	@Mock
	AuthTokenService tokenService;

	@Mock
	ChecklistServiceImpl questionsService;

	@Mock
	Environment env;

	@InjectMocks
	ChecklistController auditCheckListController;

	@Mock
	ChecklistRepository questionsRepository;

	@Test
	public void contextLoads() {
		assertNotNull(auditCheckListController);
	}

	@Test
	public void testGetChecklist() throws AuditTypeException {
		ResponseEntity<?> responseEntity = null;
		Set<String> questionsList = new LinkedHashSet<>();
		questionsList.add("How are you");
		when(tokenService.checkTokenValidity("token")).thenReturn(true);
		when(questionsService.findQuestionList("Internal")).thenReturn(questionsList);
		responseEntity = auditCheckListController.findChecklist("token", "Internal");
		assertNotNull(responseEntity);
	}

	@Test
	public void testGetChecklistTokenInvalid() throws AuditTypeException {
		ResponseEntity<?> responseEntity = null;
		when(tokenService.checkTokenValidity("token")).thenReturn(false);
		responseEntity = auditCheckListController.findChecklist("token", "Internal");
		assertEquals(HttpStatus.FORBIDDEN, responseEntity.getStatusCode());
	}

//	@Test
//	public void testGetChecklistException() {
//		Set<String> questions = new LinkedHashSet<>();
//
//		questions.add("Have all Change requests followed SDLC before PROD move?");
//		when(tokenService.checkTokenValidity("token")).thenReturn(true);
//		when(questionsService.findQuestionList("Inter")).thenThrow(AuditTypeException.class);
//		AuditTypeException exception = assertThrows(AuditTypeException.class, () -> {
//			auditCheckListController.findChecklist("token", "ss");
//		});
//
//		String expectedMessage = "Invalid audit type";
//		String actualMessage = exception.getMessage();
//
//		assertTrue(actualMessage.contains(expectedMessage));
//	}

}
