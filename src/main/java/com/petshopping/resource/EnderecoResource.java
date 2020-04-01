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

import com.petshopping.domain.Endereco;
import com.petshopping.services.EnderecoServices;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoResource {
	@Autowired
	private EnderecoServices service;
   @RequestMapping(method = RequestMethod.GET)
	public List<Endereco> listar(){
		return service.listarendereco();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Endereco buscarporId(@PathVariable Integer id) {
		return service.buscar(id);
	}
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salve(@RequestBody Endereco endereco){
		Endereco obj = service.save(endereco);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getNumero())
				.toUri();
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody Endereco endereco,@PathVariable Integer id){
		endereco.setNumero(id);
		service.update(endereco);
		return ResponseEntity.noContent().build();
		
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/{id}")
	public ResponseEntity<Void> delet(@PathVariable Integer id){
		service.deletByid(id);
		return ResponseEntity.noContent().build();
	}
	

}
