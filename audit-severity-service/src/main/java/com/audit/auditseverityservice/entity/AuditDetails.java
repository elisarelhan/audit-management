package com.audit.auditseverityservice.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="audit_details")
public class AuditDetails {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int auditId;
	@Column
	private String auditType;
	@Column
	@CreationTimestamp
	private Date auditDate;
	@Column
	private int auditQuestions;
	public int getAuditId() {
		return auditId;
	}
	public void setAuditId(int auditId) {
		this.auditId = auditId;
	}
	public String getAuditType() {
		return auditType;
	}
	public void setAuditType(String auditType) {
		this.auditType = auditType;
	}
	public Date getAuditDate() {
		return auditDate;
	}
	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}
	public int getAuditQuestions() {
		return auditQuestions;
	}
	public void setAuditQuestions(int auditQuestions) {
		this.auditQuestions = auditQuestions;
	}
	public AuditDetails(int auditId, String auditType, Date auditDate, int auditQuestions) {
		super();
		this.auditId = auditId;
		this.auditType = auditType;
		this.auditDate = auditDate;
		this.auditQuestions = auditQuestions;
	}
	public AuditDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AuditDetails [auditId=" + auditId + ", auditType=" + auditType + ", auditDate=" + auditDate
				+ ", auditQuestions=" + auditQuestions + "]";
	}
	
	

}
