package com.petshopping.resource;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.petshopping.domain.Venda;
import com.petshopping.services.VendaService;

@RestController
@RequestMapping(value = "/vendas")
public class VendaResource {

	@Autowired
	public VendaService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<Venda>> listar(@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "size", defaultValue = "24") Integer size, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction, 
			@RequestParam(value = "orderBy", defaultValue = "quantidade") String orderBy) {
				 
		Page<Venda> pageObj = service.listarvenda(page, size, direction, orderBy);
		return ResponseEntity.ok().body(pageObj);
		
		
		 
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public Venda buscarPorId(@PathVariable Integer id) {
		return service.buscarvenda(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@PreAuthorize("hasAnyRole('FUNCIONARIO')")
	public ResponseEntity<Void> save(@Valid @RequestBody Venda venda) {
		Venda obj = service.save(venda);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId_venda())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	@PreAuthorize("hasAnyRole('FUNCIONARIO')")
	public ResponseEntity<Void> update(@RequestBody Venda venda, @PathVariable Integer id) {
		venda.setId_venda(id);
		service.update(venda);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	@PreAuthorize("hasAnyRole('FUNCIONARIO')")
	public ResponseEntity<Void> delet(@PathVariable Integer id) {
		service.deletByid(id);
		return ResponseEntity.noContent().build();
	}

}
