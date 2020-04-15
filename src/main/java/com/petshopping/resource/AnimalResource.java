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

import com.petshopping.domain.Animal;
import com.petshopping.services.AnimalServices;

@RestController
@RequestMapping(value = "/animal")
public class AnimalResource {
	@Autowired
	public AnimalServices servico;
	@RequestMapping(method = RequestMethod.GET)
	public List<Animal> listar(){
		return servico.listarproduto();
	}
	
	@RequestMapping(value = "/{id}",method =RequestMethod.GET)
	public Animal buscarporId(@PathVariable Integer id) {
		return servico.buscar(id);
	}
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salve(@Valid @RequestBody Animal animal){
		Animal obj= servico.save(animal);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId_animal()).toUri();
			 
		return ResponseEntity.created(uri).build();
		
	}
	@RequestMapping(method = RequestMethod.PUT,value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody Animal animal,@PathVariable Integer id){
		animal.setId_animal(id);
		servico.update(animal);
		return ResponseEntity.noContent().build();
	}
	@RequestMapping(method = RequestMethod.DELETE,value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		servico.deletByid(id);
		return ResponseEntity.noContent().build();
	}

}
