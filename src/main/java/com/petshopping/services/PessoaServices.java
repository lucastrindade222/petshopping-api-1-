package com.petshopping.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshopping.domain.Pessoa;
import com.petshopping.repositores.PesooaRepositores;

@Service
public class PessoaServices {

	@Autowired
	private PesooaRepositores repo;

	public Pessoa buscar(Integer id) {
		Optional<Pessoa> obj = repo.findById(id);
		return obj.orElse(null);
	}

}
