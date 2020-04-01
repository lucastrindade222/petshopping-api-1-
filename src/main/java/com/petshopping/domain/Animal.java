package com.petshopping.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Animal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_animal;
	private String nome;
	private String raca;
	private String pelagem;
	private Long idade;
	private Long pesso;
	private Long tamanho;

	public Animal() {

	}

	public Animal(Integer id_animal, String nome, String raca, String pelagem, Long idade, Long pesso, Long tamanho) {
		super();
		this.id_animal = id_animal;
		this.nome = nome;
		this.raca = raca;
		this.pelagem = pelagem;
		this.idade = idade;
		this.pesso = pesso;
		this.tamanho = tamanho;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_animal == null) ? 0 : id_animal.hashCode());
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
		Animal other = (Animal) obj;
		if (id_animal == null) {
			if (other.id_animal != null)
				return false;
		} else if (!id_animal.equals(other.id_animal))
			return false;
		return true;
	}

	public Integer getId_animal() {
		return id_animal;
	}

	public void setId_animal(Integer id_animal) {
		this.id_animal = id_animal;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getPelagem() {
		return pelagem;
	}

	public void setPelagem(String pelagem) {
		this.pelagem = pelagem;
	}

	public Long getIdade() {
		return idade;
	}

	public void setIdade(Long idade) {
		this.idade = idade;
	}

	public Long getPesso() {
		return pesso;
	}

	public void setPesso(Long pesso) {
		this.pesso = pesso;
	}

	public Long getTamanho() {
		return tamanho;
	}

	public void setTamanho(Long tamanho) {
		this.tamanho = tamanho;
	}

}
