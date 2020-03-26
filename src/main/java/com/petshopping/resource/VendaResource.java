package com.petshopping.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.petshopping.domain.Venda;
import com.petshopping.services.VendaService;

@RestController
@RequestMapping(value = "/Vendas")
public class VendaResource {

	@Autowired
	public VendaService service;

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public Venda buscarPorId(@PathVariable Integer id) {
		return service.buscarvenda(id);
	}
}
