package com.petshopping.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Historico implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_consuta;
	private String data_consulta;
	private Date hoje; 
	
	
	@ManyToOne
	@JoinColumn(name = "servico")
	private Servicos  servicos;

	@ManyToOne
	@JoinColumn(name = "animal")
	private Animal animal;
	
	
	public Historico() {
		
	}
	
	
	public Historico(Integer id_consuta, String data_consulta, Servicos servicos , Animal animal,Date hoje) {
		super();
		this.id_consuta = id_consuta;
		this.data_consulta = data_consulta;
		this.servicos = servicos;
		this.animal = animal;
		this.hoje= hoje;
	}

	
	
	
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_consuta == null) ? 0 : id_consuta.hashCode());
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
		Historico other = (Historico) obj;
		if (id_consuta == null) {
			if (other.id_consuta != null)
				return false;
		} else if (!id_consuta.equals(other.id_consuta))
			return false;
		return true;
	}
	


	public Integer getId_consuta() {
		return id_consuta;
	}

	public void setId_consuta(Integer id_consuta) {
		this.id_consuta = id_consuta;
	}

	public String getData_consulta() {
		return data_consulta;
	}

	public void setData_consulta(String data_consulta) {
		this.data_consulta = data_consulta;
	}

	 

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}


	public Servicos getServicos() {
		return servicos;
	}


	public void setServicos(Servicos servicos) {
		this.servicos = servicos;
	}


	public Date getHoje() {
		return hoje;
	}


	public void setHoje(Date hoje) {
		this.hoje = hoje;
	}

	
	
	
	
}
