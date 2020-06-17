package com.petshopping.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Servicos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_servico;
	@NotBlank(message = "O CPF é de preenchimento obrigatório")
	private String descri_S;

	@NotNull(message = "O valor é de preenchimento obrigatório")
	private Long valor;

	private String nomefoto;
	
	
	 
	@OneToMany(mappedBy = "servico",cascade = CascadeType.ALL)
	@JsonIgnore
	public List<Venda> venda_se = new ArrayList<Venda>();

	
	
	public Servicos() {
	}

	public Servicos(Integer id_servico, String descri_S,
	@NotNull(message = "O valor é de preenchimento obrigatório") Long valor) {
		super();
		this.id_servico = id_servico;
		this.descri_S = descri_S;
		this.valor = valor;
		
	}

	public Integer getId_servico() {
		return id_servico;
	}

	public void setId_servico(Integer id_servico) {
		this.id_servico = id_servico;
	}

	public String getDescri_S() {
		return descri_S;
	}

	public void setDescri_S(String descri_S) {
		this.descri_S = descri_S;
	}

	public Long getValor() {
		return valor;
	}

	public void setValor(Long valor) {
		this.valor = valor;
	}

	 
	public List<Venda> getVenda_se() {
		return venda_se;
	}

	public void setVenda_se(List<Venda> venda_se) {
		this.venda_se = venda_se;
	}

	public String getNomefoto() {
		return nomefoto;
	}

	public void setNomefoto(String nomefoto) {
		this.nomefoto = nomefoto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_servico == null) ? 0 : id_servico.hashCode());
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
		Servicos other = (Servicos) obj;
		if (id_servico == null) {
			if (other.id_servico != null)
				return false;
		} else if (!id_servico.equals(other.id_servico))
			return false;
		return true;
	}

}