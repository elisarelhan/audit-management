package com.audit.authservice.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	@Getter
	@Setter
	private String token;
	@Getter
	@Setter
	private Long expiresIn;

//	public JwtResponse(String jwttoken, Long expiresIn) {
//		super();
//		this.jwttoken = jwttoken;
//		this.expiresIn = expiresIn;
//	}
//
//	public Long getExpiresIn() {
//		return expiresIn;
//	}
//
//
//	public String getToken() {
//		return this.jwttoken;
//	}
}