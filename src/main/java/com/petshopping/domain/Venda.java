package com.petshopping.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Venda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_venda;
	private Date de_venda;
	
	@NotNull(message = "A quantidade é de preenchimento obrigatório")
	private String quantidade;
	
	@NotNull(message = "A total de venda é de preenchimento obrigatório")
	private Long total_venda;
	
	
	@OneToMany(mappedBy = "venda_se",cascade = CascadeType.ALL)
	public List<Servicos> servico = new ArrayList<Servicos>();
	
	@OneToMany(mappedBy = "venda_Pro",cascade = CascadeType.ALL)
	public List<Produtos> produto = new ArrayList<Produtos>();
	
	
	 
	@ManyToOne
	@JoinColumn(name = "pessoa_venda")
	@JsonIgnore
	private Pessoa pessoa;

	public Venda() {

	}

	public Venda(Integer id_venda, Date de_venda, String quantidade, Long total_venda,Pessoa pessoa) {
		super();
		this.id_venda = id_venda;
		this.de_venda = de_venda;
		this.quantidade = quantidade;
		this.total_venda = total_venda;
		this.pessoa = pessoa;
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

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public Long getTotal_venda() {
		return total_venda;
	}

	public void setTotal_venda(Long total_venda) {
		this.total_venda = total_venda;
	}

	public List<Servicos> getServico() {
		return servico;
	}

	public void setServico(List<Servicos> servico) {
		this.servico = servico;
	}

	public List<Produtos> getProduto() {
		return produto;
	}

	public void setProduto(List<Produtos> produto) {
		this.produto = produto;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	

}
