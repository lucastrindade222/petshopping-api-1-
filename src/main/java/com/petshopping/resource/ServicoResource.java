package com.petshopping.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.petshopping.domain.Servicos;
import com.petshopping.services.ServicosServices;

@RestController
@RequestMapping(value ="/animal")
public class ServicoResource {

	@Autowired
	private ServicosServices services;
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public Servicos buscarporId(@PathVariable Integer id) {
		return services.buscar(id);
	}
	
}
