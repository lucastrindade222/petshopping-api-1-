package com.petshopping.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.petshopping.domain.Cliente;
import com.petshopping.services.ClienteService;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteResource {
	@Autowired
	private ClienteService service;

	
	@RequestMapping(value = "{/id}",method = RequestMethod.GET)
	public Cliente buscarporId(@PathVariable Integer id) {
		
	  return service.buscar(id);
	}
	
	
	
}
