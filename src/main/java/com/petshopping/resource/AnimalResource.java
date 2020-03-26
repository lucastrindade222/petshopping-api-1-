package com.petshopping.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.petshopping.domain.Animal;
import com.petshopping.services.AnimalServices;

@RestController
@RequestMapping(value = "/animal")
public class AnimalResource {
	@Autowired
	public AnimalServices servico;
	
	@RequestMapping(value = "/{id}",method =RequestMethod.GET)
	public Animal buscarporId(@PathVariable Integer id) {
		return servico.buscar(id);
	}

}
