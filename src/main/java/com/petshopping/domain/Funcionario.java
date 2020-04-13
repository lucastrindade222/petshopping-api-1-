package com.petshopping.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.petshopping.domain.enums.Funcoes;

@Embeddable
public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;

	 

	private String login;
	private String senha;
	private String funcao;
	private Date dt_admin;
	private Long salario;
	@Enumerated(EnumType.STRING)
	private Funcoes funcoes;

	public Funcionario() {
		
	}

	public Funcionario(String login, String senha, String funcao, Date dt_admin, Long salario) {
		super();
		this.login = login;
		this.senha = senha;
		this.funcao = funcao;
		this.dt_admin = dt_admin;
		this.salario = salario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public Date getDt_admin() {
		return dt_admin;
	}

	public void setDt_admin(Date dt_admin) {
		this.dt_admin = dt_admin;
	}

	public Long getSalario() {
		return salario;
	}

	public void setSalario(Long salario) {
		this.salario = salario;
	}

	
	
}
