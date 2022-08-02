package com.audit.auditseverityservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="audit_response")
public class AuditResponse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int responseId;
	@Column
	private String projectExecutionStatus;
	@Column
	private String remedialActionDuration;
	public int getResponseId() {
		return responseId;
	}
	public void setResponseId(int auditId) {
		this.responseId = auditId;
	}
	public String getProjectExecutionStatus() {
		return projectExecutionStatus;
	}
	public void setProjectExecutionStatus(String projectExecutionStatus) {
		this.projectExecutionStatus = projectExecutionStatus;
	}
	public String getRemedialActionDuration() {
		return remedialActionDuration;
	}
	public void setRemedialActionDuration(String remedialActionDuration) {
		this.remedialActionDuration = remedialActionDuration;
	}
	public AuditResponse(int responseId, String projectExecutionStatus, String remedialActionDuration) {
		super();
		this.responseId = responseId;
		this.projectExecutionStatus = projectExecutionStatus;
		this.remedialActionDuration = remedialActionDuration;
	}
	public AuditResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AuditResponse [responseId=" + responseId + ", projectExecutionStatus=" + projectExecutionStatus
				+ ", remedialActionDuration=" + remedialActionDuration + "]";
	}
	

}
