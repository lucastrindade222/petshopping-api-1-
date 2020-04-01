package com.petshopping.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)// erro 
	private Integer numero;
	private String rua;
	private String bairro;
	private String cidade;
	private String uf;
	private String cep;
	private String complemento;
	
	
public Endereco() {
	
}


public Endereco(String rua, Integer numero, String bairro, String cidade, String uf, String cep, String complemento) {
	super();
	this.rua = rua;
	this.numero = numero;
	this.bairro = bairro;
	this.cidade = cidade;
	this.uf = uf;
	this.cep = cep;
	this.complemento = complemento;
}


public String getRua() {
	return rua;
}


public void setRua(String rua) {
	this.rua = rua;
}


public Integer getNumero() {
	return numero;
}


public void setNumero(Integer numero) {
	this.numero = numero;
}


public String getBairro() {
	return bairro;
}


public void setBairro(String bairro) {
	this.bairro = bairro;
}


public String getCidade() {
	return cidade;
}


public void setCidade(String cidade) {
	this.cidade = cidade;
}


public String getUf() {
	return uf;
}


public void setUf(String uf) {
	this.uf = uf;
}


public String getCep() {
	return cep;
}


public void setCep(String cep) {
	this.cep = cep;
}


public String getComplemento() {
	return complemento;
}


public void setComplemento(String complemento) {
	this.complemento = complemento;
}
	


	
}
