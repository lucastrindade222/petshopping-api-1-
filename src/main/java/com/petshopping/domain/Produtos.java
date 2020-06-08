package com.petshopping.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	private String nomefoto;
	

	@ManyToOne
	@JoinColumn(name = "venta_id")
	@JsonIgnore
	private Venda venda_Pro;

	public Produtos() {

	}
	
	
	

	public Produtos(Integer id_produto,
			@NotBlank(message = "O nome é de preenchimento obrigatório") @Length(max = 60, min = 3, message = "O nome deve ter entre 3 e 80 caracteres") String descri,
			@NotNull(message = "O valor é de preenchimento obrigatório") Long valor, Venda venda_Pro) {
		super();
		this.id_produto = id_produto;
		this.descri_P = descri;
		this.valor = valor;
		this.venda_Pro = venda_Pro;
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

	public Venda getVenda_Pro() {
		return venda_Pro;
	}

	public void setVenda_P(Venda venda_pro) {
		this.venda_Pro = venda_pro;
	}

	public void setVenda_Pro(Venda venda_Pro) {
		this.venda_Pro = venda_Pro;
	}

	public String getDescri_P() {
		return descri_P;
	}

	public void setdescri_P(String descri) {
		this.descri_P = descri;
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
