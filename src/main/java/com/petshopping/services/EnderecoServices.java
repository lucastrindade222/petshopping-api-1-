package com.petshopping.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshopping.domain.Endereco;
import com.petshopping.repositores.EnderecoRepositores;

@Service
public class EnderecoServices {

	@Autowired
	private EnderecoRepositores repo;
	
	public Endereco buscar(Integer id) {
		Optional<Endereco> obj = repo.findById(id);
		return obj.orElse(null);	
		}
	
}
