package com.audit.auditseverityservice.repository;

import javax.transaction.Transactional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.audit.auditseverityservice.entity.AuditDetails;
import com.audit.auditseverityservice.entity.AuditRequest;
@Repository
@Transactional
public interface RequestRepository extends JpaRepository<AuditRequest, Integer> {
	@Query(value = "INSERT INTO audit_request VALUES (?,?,?,?,?)", nativeQuery = true)
	  void saveAll(int requestId,String projectName, String
	  projectManagerName,String applicationOwnername, AuditDetails auditDetails);
	 
}
