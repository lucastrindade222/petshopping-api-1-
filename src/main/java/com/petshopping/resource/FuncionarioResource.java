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

import com.petshopping.domain.Funcionario;
import com.petshopping.services.FuncionarioServices;

@RestController
@RequestMapping(value = "/funcionario")
public class FuncionarioResource {
	@Autowired
	private FuncionarioServices service;

	@RequestMapping(method = RequestMethod.GET)
	public List<Funcionario> listar() {
		return service.listarfuncionario();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Funcionario buscarporId(@PathVariable Integer id) {
		return service.buscar(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salve(@RequestBody Funcionario funcionario) {
		Funcionario obj = service.save(funcionario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId_func())
				.toUri();
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody Funcionario funcionario, @PathVariable Integer id) {
		funcionario.setId_func(id);
		service.update(funcionario);
		return ResponseEntity.noContent().build();

	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/{id}")
	public ResponseEntity<Void> delet(@PathVariable Integer id){
		service.deletByid(id);
		return ResponseEntity.noContent().build();
		
		
	}

}
