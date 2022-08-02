package com.audit.auditseverityservice.repository;

import java.sql.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.audit.auditseverityservice.entity.AuditDetails;
@Repository
@Transactional
public interface AuditDetailsRepository extends JpaRepository<AuditDetails, Integer> {
	
}
