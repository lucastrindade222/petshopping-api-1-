package com.petshopping.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Venda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_venda;
	private Date de_venda;
	private Long quantidade;
	private Long total_venda;



	public Venda() {

	}

	public Venda(Integer id_venda, Date de_venda, Long quantidade, Long total_venda) {
		super();
		this.id_venda = id_venda;
		this.de_venda = de_venda;
		this.quantidade = quantidade;
		this.total_venda = total_venda;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_venda == null) ? 0 : id_venda.hashCode());
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
		Venda other = (Venda) obj;
		if (id_venda == null) {
			if (other.id_venda != null)
				return false;
		} else if (!id_venda.equals(other.id_venda))
			return false;
		return true;
	}

	public Integer getId_venda() {
		return id_venda;
	}

	public void setId_venda(Integer id_venda) {
		this.id_venda = id_venda;
	}

	public Date getDe_venda() {
		return de_venda;
	}

	public void setDe_venda(Date de_venda) {
		this.de_venda = de_venda;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public Long getTotal_venda() {
		return total_venda;
	}

	public void setTotal_venda(Long total_venda) {
		this.total_venda = total_venda;
	}


}
