package com.petshopping.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.petshopping.domain.enums.Funcoes;
import com.petshopping.domain.enums.Tipo;
import com.petshopping.services.validators.PessoaInsert;

@Entity
@PessoaInsert
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_pessoa;

	@NotBlank(message = "O nome é de preenchimento obrigatório")
	@Length(max = 60, min = 3, message = "O nome deve ter entre 3 e 80 caracteres")
	private String nome;

	@NotBlank(message = "O CPF é de preenchimento obrigatório")
	@Length(max = 11, min = 11, message = "O nome deve ter entre 3 e 80 caracteres")
	private String cpf;

//	@NotBlank(message = "O nome do login é de preenchimento obrigatório")
	private String login;

	@Column(length = 60, nullable = false, unique = true)
	@NotBlank(message = "O e-mail é de preenchimento obrigatório")
	@Email(message = "Informe um e-mail válido")
	private String email;

	@NotBlank(message = "A senha é de preenchimento obrigatório")
	private String senha;

	private Date dt_cadast;

	private Long salario;

	@Enumerated(EnumType.STRING)
	private Funcoes funcoes;

	@ElementCollection
	@CollectionTable(name = "usuario_telefone")
	@Column(name = "telefone")
	@NotNull(message = "Informe um telefone para contato")
	@Size(min = 1, message = "É necessário informar pelo menos um telefone para contato")
	private List<String> telefones = new ArrayList<>();

	@NotNull(message = "O endereço preenchimento obrigatório")
	@Embedded
	private Endereco endereco;

	@OneToMany(mappedBy = "pessoa")
	@JsonIgnore
	private List<Venda> venda = new ArrayList<Venda>();

	@OneToMany(mappedBy = "pessoa")
	@JsonIgnore
	private List<Animal> animal = new ArrayList<Animal>();

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "usuario_perfil")
	@NotNull(message = "É necessário informar o perfil do usuário.")
	@Size(min = 1, message = "Informe pelo menos um perfil para o usuário")
	private Set<Integer> perfis = new HashSet<>();

	public Pessoa() {
	}

	public Pessoa(Integer id_pessoa, String nome, String cpf, String email, Endereco endereco) {
		super();
		this.id_pessoa = id_pessoa;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.endereco = endereco;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_pessoa == null) ? 0 : id_pessoa.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (id_pessoa == null) {
			if (other.id_pessoa != null)
				return false;
		} else if (!id_pessoa.equals(other.id_pessoa))
			return false;
		return true;
	}

	public Integer getId_pessoa() {
		return id_pessoa;
	}

	public void setId_pessoa(Integer id_pessoa) {
		this.id_pessoa = id_pessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDt_cadast() {
		return dt_cadast;
	}

	public void setDt_cadast(Date dt_cadast) {
		this.dt_cadast = dt_cadast;
	}

	public Long getSalario() {
		return salario;
	}

	public void setSalario(Long salario) {
		this.salario = salario;
	}

	public Funcoes getFuncoes() {
		return funcoes;
	}

	public void setFuncoes(Funcoes funcoes) {
		this.funcoes = funcoes;
	}

	public List<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<String> telefones) {
		this.telefones = telefones;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Venda> getVenda() {
		return venda;
	}

	public void setVenda(List<Venda> venda) {
		this.venda = venda;
	}

	public List<Animal> getAnimal() {
		return animal;
	}

	public void setAnimal(List<Animal> animal) {
		this.animal = animal;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void addPerfil(Tipo tipo) {
		perfis.add(tipo.getCodigo());
	}

	public Set<Tipo> getPerfis() {
		return perfis.stream().map(x -> Tipo.toEnum(x)).collect(Collectors.toSet());
	}

}
