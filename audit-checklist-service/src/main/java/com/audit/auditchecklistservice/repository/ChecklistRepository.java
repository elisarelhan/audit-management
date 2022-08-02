package com.audit.auditchecklistservice.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.audit.auditchecklistservice.entity.AuditChecklist;


@Repository
public interface ChecklistRepository extends JpaRepository<AuditChecklist, Serializable> {
	
	List<AuditChecklist> findQuestionsByauditType(String auditType);
}
