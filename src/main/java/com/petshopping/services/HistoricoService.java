package com.petshopping.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshopping.domain.Historico;
import com.petshopping.repositores.HistoricoRepositores;
import com.petshopping.service.Exception.ObejectNotFoudException;

@Service
public class HistoricoService {

	@Autowired
	private HistoricoRepositores repo;
	
	
	public List<Historico> listarHistorico(){
		return repo.findAll();
	}
	
	
	public Historico buscar(Integer id) {
		Optional<Historico> obj = repo.findById(id);
	 
		return obj.orElseThrow(() -> new ObejectNotFoudException( "historico não encontrado. Id: "+id));
		 

	}
	public Historico salve(Historico historico) {
		historico.setData_consulta(new Date());
		return repo.save(historico);
	}
	
	public Historico update(Historico historico) {
		return repo.save(historico);
	}
	
	public void deletByid(Integer id) {
		repo.deleteById(id);;
	}

	
}
