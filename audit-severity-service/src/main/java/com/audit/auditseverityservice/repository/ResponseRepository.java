package com.audit.auditseverityservice.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.audit.auditseverityservice.entity.AuditDetails;
import com.audit.auditseverityservice.entity.AuditResponse;
@Repository
@Transactional
public interface ResponseRepository extends JpaRepository<AuditResponse, Integer> {
	
	@Query(value = "INSERT INTO audit_response VALUES (?,?,?)", nativeQuery = true)
	void save(int responseId,String executionStatus, String remedialActionDuration);
	
	List<AuditResponse> findById(int responseId);
	
	

}
