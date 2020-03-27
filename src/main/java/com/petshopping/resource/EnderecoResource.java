package com.petshopping.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.petshopping.domain.Endereco;
import com.petshopping.services.EnderecoServices;
 

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoResource {
@Autowired
	private EnderecoServices service;
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public Endereco buscarporId(@PathVariable Integer id) {
		return service.buscar(id);
	}
	
	
}
