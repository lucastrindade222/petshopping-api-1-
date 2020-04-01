package com.petshopping.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshopping.domain.Cliente;
import com.petshopping.repositores.ClienteRepositores;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepositores repo;
  
	public List<Cliente> listarcliente(){
		return repo.findAll();
	}
	
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public Cliente save(Cliente cliente){
		return repo.save(cliente);
		
	}
	
	public Cliente update(Cliente cliente) {
		return repo.save(cliente);
	}
	
	public void deletByid(Integer id) {
		repo.deleteById(id);
	}

}
