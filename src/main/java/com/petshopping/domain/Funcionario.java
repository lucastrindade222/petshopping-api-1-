package com.petshopping.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_func;
	private String login;
	private String senha;
	private Endereco endereco;
	private String funcao;
	private Date dt_admin;
	private Long salario;

	public Funcionario() {

	}

	public Funcionario(Integer id_func, String login, String senha, String funcao, Date dt_admin, Long salario) {
		super();
		this.id_func = id_func;
		this.login = login;
		this.senha = senha;
		this.funcao = funcao;
		this.dt_admin = dt_admin;
		this.salario = salario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_func == null) ? 0 : id_func.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (id_func == null) {
			if (other.id_func != null)
				return false;
		} else if (!id_func.equals(other.id_func))
			return false;
		return true;
	}

	public Integer getId_func() {
		return id_func;
	}

	public void setId_func(Integer id_func) {
		this.id_func = id_func;
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
