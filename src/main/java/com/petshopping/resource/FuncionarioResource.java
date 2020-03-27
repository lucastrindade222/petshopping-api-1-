package com.petshopping.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.petshopping.domain.Funcionario;
import com.petshopping.services.FuncionarioServices;

@RestController
@RequestMapping(value = "/funcionario")
public class FuncionarioResource {
	@Autowired
	private FuncionarioServices service;

	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public Funcionario buscarporId(@PathVariable Integer id) {
		return service.buscar(id);
	}
	
	
}
