package com.petshopping.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshopping.domain.Servicos;
import com.petshopping.repositores.ServicoRepositores;

@Service
public class ServicosServices {

	@Autowired
	public ServicoRepositores sevico;
	
	
	public Servicos buscar(Integer id){
		Optional<Servicos> obj = sevico.findById(id);
		return obj.orElse(null);
	}

}
