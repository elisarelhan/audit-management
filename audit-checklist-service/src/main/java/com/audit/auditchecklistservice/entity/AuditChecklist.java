package com.audit.auditchecklistservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "audit_checklist")
//@Getter
//@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuditChecklist {

	@Id
	@Column(name = "question_id")
	@Getter
	@Setter
	private int questionId;

	@Column(name = "audit_type")
	@Getter
	@Setter
	private String auditType;

	@Column
	@Getter
	@Setter
	private String questions;

}
