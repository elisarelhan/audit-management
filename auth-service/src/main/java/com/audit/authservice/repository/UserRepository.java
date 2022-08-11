package com.audit.authservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.audit.authservice.entity.UserCredentials;

@Repository
public interface UserRepository extends JpaRepository<UserCredentials, Integer> {

	UserCredentials findByUsername(String username);

}