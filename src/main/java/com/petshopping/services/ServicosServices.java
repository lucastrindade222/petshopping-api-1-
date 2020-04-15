package com.petshopping.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshopping.domain.Servicos;
import com.petshopping.repositores.ServicoRepositores;
import com.petshopping.service.Exception.ObejectNotFoudException;

@Service
public class ServicosServices {

	@Autowired
	public ServicoRepositores repo;

	public List<Servicos> listarservico() {
		return repo.findAll();
	}

	public Servicos buscar(Integer id) {
		Optional<Servicos> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObejectNotFoudException( "Serviço não encontrado. Id: "+id));
	}

	public Servicos salve(Servicos servicos) {
		return repo.save(servicos);
	}
	public Servicos update(Servicos servicos) {
		return repo.save(servicos);
	}
	
	public void deletbyid(Integer id) {
		repo.deleteById(id);
	}
}
