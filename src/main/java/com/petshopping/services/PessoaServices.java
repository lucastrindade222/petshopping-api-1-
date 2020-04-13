package com.petshopping.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshopping.domain.Pessoa;
import com.petshopping.repositores.PesooaRepositores;
import com.petshopping.service.Exception.ObejectNotFoudException;

@Service
public class PessoaServices {

	@Autowired
	private PesooaRepositores repo;

	public List<Pessoa> listarpessoa() {
		return repo.findAll();
	}

	public Pessoa buscar(Integer id) {
		Optional<Pessoa> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObejectNotFoudException( "Evento não encontrado. Id: "+id));
	}

	public Pessoa save(Pessoa pessoa) {
		 
		
		return repo.save(pessoa);
	}

	public Pessoa update(Pessoa pessoa) {
		return repo.save(pessoa);
	}

	public void deletByid(Integer id) {
		repo.deleteById(id);
	}
}
