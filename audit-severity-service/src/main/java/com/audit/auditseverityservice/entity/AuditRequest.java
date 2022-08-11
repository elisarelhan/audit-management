package com.audit.auditseverityservice.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "audit_request")
//@Getter
//@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuditRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column
	@Getter
	@Setter
	private int requestId;
	@Column
	@Getter
	@Setter
	private String projectName;
	@Column(name = "project_manager_name")
	@Getter
	@Setter
	private String prjManager;
	@Column(name = "application_owner_name")
	@Getter
	@Setter
	private String appOwner;

	@OneToOne(cascade = CascadeType.ALL)
	@Getter
	@Setter
	private AuditDetails auditDetails;

//	public int getRequestId() {
//		return requestId;
//	}
//
//	public void setRequestId(int requestId) {
//		this.requestId = requestId;
//	}
//
//	public String getProjectName() {
//		return projectName;
//	}
//
//	public void setProjectName(String projectName) {
//		this.projectName = projectName;
//	}
//
//	public String getProjectManagerName() {
//		return projectManagerName;
//	}
//
//	public void setProjectManagerName(String projectManagerName) {
//		this.projectManagerName = projectManagerName;
//	}
//
//	public String getApplicationOwnerName() {
//		return applicationOwnerName;
//	}
//
//	public void setApplicationOwnerName(String applicationOwnerName) {
//		this.applicationOwnerName = applicationOwnerName;
//	}
//
//	public AuditDetails getAuditDetails() {
//		return auditDetails;
//	}
//
//	public void setAuditDetails(AuditDetails auditDetails) {
//		this.auditDetails = auditDetails;
//	}
//
//	public AuditRequest(int requestId, String projectName, String projectManagerName, String applicationOwnerName,
//			AuditDetails auditDetails) {
//		super();
//		this.requestId = requestId;
//		this.projectName = projectName;
//		this.projectManagerName = projectManagerName;
//		this.applicationOwnerName = applicationOwnerName;
//		this.auditDetails = auditDetails;
//	}
//
//	public AuditRequest() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	@Override
//	public String toString() {
//		return "AuditRequest [requestId=" + requestId + ", projectName=" + projectName + ", projectManagerName="
//				+ projectManagerName + ", applicationOwnerName=" + applicationOwnerName + ", auditDetails="
//				+ auditDetails + "]";
//	}

}
