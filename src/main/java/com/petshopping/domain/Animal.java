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

@Entity//  com esta anotação o spring boot  transforma as classe em uma tabelas 
public class Animal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id // esta aqui trasforma esta variavel em uma chave primaria no banco 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_animal;

	@NotBlank(message = "O nome é de preenchimento obrigatório")
	@Length(max = 60, min = 3, message = "O nome deve ter entre 3 e 60 caracteres")
	private String nome;

	@NotBlank(message = "A Raça é de preenchimento obrigatório")
	private String raca;

	@NotBlank(message = "A pelagem é de preenchimento obrigatório") 
	private String pelagem;

	@NotNull(message = "A idade é de preenchimento obrigatório")
	private Long idade;
	
	@NotNull(message = "O pesso é de preenchimento obrigatório")
	private Long pesso;
	
	@NotNull(message = "O tamanho é de preenchimento obrigatório")
	private Long tamanho;

	@ManyToOne
	@JoinColumn(name = "pessoa")
	private Pessoa pessoa;
	
	
	public Animal() {

	}

	public Animal(Integer id_animal, String nome, String raca, String pelagem, Long idade, Long pesso, Long tamanho,
			Pessoa pessoa) {
		super();
		this.id_animal = id_animal;
		this.nome = nome;
		this.raca = raca;
		this.pelagem = pelagem;
		this.idade = idade;
		this.pesso = pesso;
		this.tamanho = tamanho;
		this.pessoa = pessoa;
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

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	
	
}
