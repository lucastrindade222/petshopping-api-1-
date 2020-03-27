package com.petshopping.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshopping.domain.Funcionario;
import com.petshopping.repositores.FuncionarioRepositores;

@Service
public class FuncionarioServices {
	@Autowired
	private FuncionarioRepositores repo;
	
	
	public Funcionario buscar(Integer id) {
		Optional<Funcionario> obj =repo.findById(id);
		return obj.orElse(null);
	}
	
	

}
