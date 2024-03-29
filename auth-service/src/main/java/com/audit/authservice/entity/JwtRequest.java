package com.audit.authservice.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
public class JwtRequest implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;
	
	@Getter @Setter private String username;
	@Getter @Setter private String password;
	
	//need default constructor for JSON Parsing
//	public JwtRequest()
//	{
//		
//	}
//
//	public JwtRequest(String username, String password) {
//		this.setUsername(username);
//		this.setPassword(password);
//	}
//
//	public String getUsername() {
//		return this.username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public String getPassword() {
//		return this.password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
}