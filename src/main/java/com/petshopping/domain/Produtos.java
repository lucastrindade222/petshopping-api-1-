package com.petshopping.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Produtos implements Serializable {
	private static final long serialVersionUID = 1L;
	

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_produto;
	private String desc_prod;
	private Long valor;
	
	@ManyToOne
    @JoinColumn(name = "venta_id") 
	@JsonIgnore
	private Venda venda_Pro;
	
	
	 public Produtos() {
		 
	 }
	
	
	
	public Produtos(Integer id_produto, String desc_prod, Long valor, Venda venda_pro) {
		super();
		this.id_produto = id_produto;
		this.desc_prod = desc_prod;
		this.valor = valor;
		this.venda_Pro = venda_pro;
	}



	public Integer getId_produto() {
		return id_produto;
	}
	public void setId_produto(Integer id_produto) {
		this.id_produto = id_produto;
	}
	public String getDesc_prod() {
		return desc_prod;
	}
	public void setDesc_prod(String desc_prod) {
		this.desc_prod = desc_prod;
	}
	public Long getValor() {
		return valor;
	}
	public void setValor(Long valor) {
		this.valor = valor;
	}



	public Venda getVenda_Pro() {
		return venda_Pro;
	}



	public void setVenda_P(Venda venda_pro) {
		this.venda_Pro = venda_pro;
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


	public Produtos(Integer id_produto, String desc_prod, Long valor) {
		super();
		this.id_produto = id_produto;
		this.desc_prod = desc_prod;
		this.valor = valor;
	}



	
	
	
	
	
	
	
	
}
