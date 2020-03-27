package com.petshopping.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.petshopping.domain.Pessoa;
import com.petshopping.services.PessoaServices;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaResource {

	@Autowired
	private PessoaServices service;
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public Pessoa buscarporId(@PathVariable Integer id) {
		return service.buscar(id);
	}
	
}
