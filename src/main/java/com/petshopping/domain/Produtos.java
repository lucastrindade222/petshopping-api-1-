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

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Produtos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_produto;

	@NotBlank(message = "O nome é de preenchimento obrigatório")
	@Length(max = 60, min = 3, message = "O nome deve ter entre 3 e 80 caracteres")
	private String descri_P;

	@NotNull(message = "O valor é de preenchimento obrigatório")
	private Long valor;
	
	private int quantidade;
	
	private String nomefoto;
	

	@OneToMany(mappedBy = "produtos",cascade = CascadeType.ALL)
	@JsonIgnore
	public List<Venda> vanda_P = new ArrayList<Venda>();
	
	public Produtos() {

	}
	
	
	

	public Produtos(Integer id_produto,
			@NotBlank(message = "O nome é de preenchimento obrigatório") @Length(max = 60, min = 3, message = "O nome deve ter entre 3 e 80 caracteres") String descri,
			@NotNull(message = "O valor é de preenchimento obrigatório") Long valor, int q) {
		super();
		this.id_produto = id_produto;
		this.descri_P = descri;
		this.valor = valor;
		
		this.quantidade= q;
	}




	public Integer getId_produto() {
		return id_produto;
	}

	public void setId_produto(Integer id_produto) {
		this.id_produto = id_produto;
	}

	public Long getValor() {
		return valor;
	}

	public void setValor(Long valor) {
		this.valor = valor;
	}



	public List<Venda> getVanda_P() {
		return vanda_P;
	}




	public void setVanda_P(List<Venda> vanda_P) {
		this.vanda_P = vanda_P;
	}




	
	

	public String getDescri_P() {
		return descri_P;
	}




	public String getNomefoto() {
		return nomefoto;
	}




	public void setNomefoto(String nomefoto) {
		this.nomefoto = nomefoto;
	}

	



	public void setDescri_P(String descri_P) {
		this.descri_P = descri_P;
	}




	public int getQuantidade() {
		return quantidade;
	}




	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_produto == null) ? 0 : id_produto.hashCode());
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
		Produtos other = (Produtos) obj;
		if (id_produto == null) {
			if (other.id_produto != null)
				return false;
		} else if (!id_produto.equals(other.id_produto))
			return false;
		return true;
	}

	
	
	
	
}
