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

import com.petshopping.domain.Venda;
import com.petshopping.services.VendaService;

@RestController
@RequestMapping(value = "/vendas")
public class VendaResource {

	@Autowired
	public VendaService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<Venda> listar() {
		return service.listarvenda();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public Venda buscarPorId(@PathVariable Integer id) {
		return service.buscarvenda(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody Venda venda) {
		Venda obj = service.save(venda);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId_venda())
				.toUri();
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody Venda venda, @PathVariable Integer id) {
		venda.setId_venda(id);
		service.update(venda);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<Void> delet(@PathVariable Integer id) {
		service.deletByid(id);
		return ResponseEntity.noContent().build();
	}

}
