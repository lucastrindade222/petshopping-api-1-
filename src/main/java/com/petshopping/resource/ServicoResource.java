package com.petshopping.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.petshopping.domain.Servicos;
import com.petshopping.services.ServicosServices;

@RestController
@RequestMapping(value ="/services")
public class ServicoResource {

	@Autowired
	private ServicosServices services;
	@RequestMapping(method = RequestMethod.GET)
	public List<Servicos> listar(){
		return services.listarservico();
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public Servicos buscarporId(@PathVariable Integer id) {
		return services.buscar(id);
	}
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salve(@Valid @RequestBody Servicos servicos){
		Servicos obj = services.salve(servicos);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId_servico())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	@RequestMapping(method = RequestMethod.PUT,value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody Servicos servicos,@PathVariable Integer id){
		servicos.setId_servico(id);
		services.update(servicos);
		return ResponseEntity.noContent().build();
	}
	@RequestMapping(method = RequestMethod.DELETE,value = "/{id}")
	public ResponseEntity<Void> delet(@PathVariable Integer id){
		services.deletbyid(id);
		return ResponseEntity.noContent().build();
	}
}
