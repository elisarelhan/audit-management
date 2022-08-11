package com.audit.auditchecklistservice.model;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.audit.auditchecklistservice.entity.AuditChecklist;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
public class AuditChecklistTest {

	AuditChecklist questions = new AuditChecklist();

	@Test
	public void testParameterizedConstructor() {
		AuditChecklist questions = new AuditChecklist(1, "Other", "Have all changes has been approved");
		assertEquals("Other", questions.getAuditType());
	}

	@Test
	public void testQuestionId() {
		questions.setQuestionId(2);
		assertEquals(2, questions.getQuestionId());
	}

	@Test
	public void testQuestionType() {
		questions.setAuditType("Internal");
		assertEquals("Internal", questions.getAuditType());
	}

	@Test
	public void testQuestion() {
		questions.setQuestions("Do you have any changes?");
		assertEquals("Do you have any changes?", questions.getQuestions());
	}

	@Test
	public void testToString() {

		String expected = "AuditChecklist(questionId=1, auditType=Internal, questions=How are you)";
		questions.setAuditType("Internal");
		questions.setQuestionId(1);
		questions.setQuestions("How are you");
		assertEquals(expected, questions.toString());

	}
}