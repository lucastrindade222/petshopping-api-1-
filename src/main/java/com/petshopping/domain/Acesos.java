package com.petshopping.domain;

import java.io.Serializable;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
public class Acesos implements Serializable {
	private static final long serialVersionUID = 1L;

	private String email;
	private String senha;
	
	
	public Acesos() {
		
	}
	
	
	
	public Acesos(String email, String senha) {
		super();
		this.email = email;
		this.senha = senha;
	}
	
	
	
	

	

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
}
