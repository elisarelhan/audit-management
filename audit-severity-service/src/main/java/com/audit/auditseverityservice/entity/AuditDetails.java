package com.audit.auditseverityservice.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "audit_details")
//@Getter
//@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuditDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	@Getter
	@Setter
	private int auditId;
	@Column
	@Getter
	@Setter
	private String auditType;
	@Column
	@CreationTimestamp
	@Getter
	@Setter
	private Date auditDate;
	@Column
	@Getter
	@Setter
	private int auditQuestions;

}
