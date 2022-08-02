package com.audit.auditchecklistservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="audit_checklist")
public class AuditChecklist {
	
	@Id
	@Column(name="question_id")
	private int questionId;
	
	@Column(name="audit_type")
	private String auditType;
	
	@Column
	 private String questions;

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getAuditType() {
		return auditType;
	}

	public void setAuditType(String auditType) {
		this.auditType = auditType;
	}

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public AuditChecklist(int questionId, String auditType, String questions) {
		super();
		this.questionId = questionId;
		this.auditType = auditType;
		this.questions = questions;
	}

	public AuditChecklist() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AuditChecklist [questionId=" + questionId + ", auditType=" + auditType + ", questions=" + questions
				+ "]";
	}
	
	
	

}
