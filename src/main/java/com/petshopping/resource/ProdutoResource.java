package com.petshopping.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.petshopping.domain.Produtos;
import com.petshopping.services.ProdutoService;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoResource {

	@Autowired
	private ProdutoService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<Produtos> listar(){
		return service.listarproduto();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public Produtos buscarPorId(@PathVariable Integer id) {
		return service.buscar(id);
	}

}
