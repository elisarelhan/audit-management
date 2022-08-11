package com.audit.auditchecklistservice.services;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.audit.auditchecklistservice.entity.AuditChecklist;
import com.audit.auditchecklistservice.exception.AuditTypeException;
import com.audit.auditchecklistservice.repository.ChecklistRepository;
import com.audit.auditchecklistservice.service.ChecklistServiceImpl;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
public class ChecklistServiceTest {

	@Mock
	ChecklistRepository questionsRespository;

	@InjectMocks
	ChecklistServiceImpl checklistService;

	@Test
	public void testGetQuestionsList() throws AuditTypeException {

		Set<String> questions = new LinkedHashSet<>();
		List<AuditChecklist> questionsList = new ArrayList<>();
		questionsList
				.add(new AuditChecklist(1, "Internal", "Have all Change requests followed SDLC before PROD move?"));
		questions.add("Have all Change requests followed SDLC before PROD move?");
		when(questionsRespository.findQuestionsByauditType("Internal")).thenReturn(questionsList);
		assertEquals(questions, checklistService.findQuestionList("Internal"));

	}

	@Test
	public void throwsExceptionWheninvalidaudittype() {
		Set<String> questions = new LinkedHashSet<>();

		questions.add("Have all Change requests followed SDLC before PROD move?");
		AuditTypeException exception = assertThrows(AuditTypeException.class, () -> {
			checklistService.findQuestionList("ss");
		});

		String expectedMessage = "Invalid audit type";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));

	}
}
