package com.petshopping.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.petshopping.domain.Pessoa;
import com.petshopping.services.PessoaServices;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaResource {

	@Autowired
	private PessoaServices service;
	@RequestMapping(method = RequestMethod.GET)
	public List<Pessoa> listar(){
		return service.listarpessoa();
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public Pessoa buscarporId(@PathVariable Integer id) {
		return service.buscar(id);
	}
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salve(@RequestBody Pessoa pessoa){
		Pessoa obj = service.save(pessoa);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId_pessoa())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	@RequestMapping(method = RequestMethod.PUT,value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody Pessoa pessoa,@PathVariable Integer id){
		pessoa.setId_pessoa(id);
		service.update(pessoa);
		return ResponseEntity.noContent().build();
	}
	@RequestMapping(method = RequestMethod.DELETE,value = "/{id}")
	public ResponseEntity<Void> delet(@PathVariable Integer id){
		service.deletByid(id);
		return ResponseEntity.noContent().build();
	}
	
}
