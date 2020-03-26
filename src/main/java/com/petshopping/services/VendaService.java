package com.petshopping.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshopping.domain.Venda;
import com.petshopping.repositores.VendaRepositores;

@Service
public class VendaService {

	@Autowired
	private VendaRepositores repo;
	
	
	public Venda buscarvenda(Integer id) {
		Optional<Venda> obj = repo.findById(id);
		return obj.orElse(null);
	}
}
