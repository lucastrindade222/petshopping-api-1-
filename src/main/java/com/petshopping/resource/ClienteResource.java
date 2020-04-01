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

import com.petshopping.domain.Cliente;
import com.petshopping.services.ClienteService;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteResource {
	@Autowired
	private ClienteService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<Cliente> listar() {
		return service.listarcliente();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Cliente buscarporId(@PathVariable Integer id) {

		return service.buscar(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salva(@RequestBody Cliente cliente) {

		Cliente obj = service.save(cliente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId_pessoa())
				.toUri();
		return ResponseEntity.noContent().build();
	}
	@RequestMapping(method = RequestMethod.PUT,value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody Cliente cliente, @PathVariable Integer id){
		cliente.setId_pessoa(id);
		service.update(cliente);
		return ResponseEntity.noContent().build();
	}
	@RequestMapping(method = RequestMethod.DELETE,value = "/{id}")
	public ResponseEntity<Void> delte(@PathVariable Integer id){
		service.deletByid(id);
		return ResponseEntity.noContent().build();
		
	}

}
