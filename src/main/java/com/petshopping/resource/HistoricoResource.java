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

import com.petshopping.domain.Historico;
import com.petshopping.services.HistoricoService;


@RestController
@RequestMapping(value = "/historico")
public class HistoricoResource {

	
	@Autowired
	public HistoricoService servico;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Historico> listar(){
		return servico.listarHistorico();
	}
	
	@RequestMapping(value = "/{id}",method =RequestMethod.GET)
	public Historico buscarporId(@PathVariable Integer id) {
		return servico.buscar(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salve(@Valid @RequestBody Historico historico){
		
		Historico obj = servico.salve(historico);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId_consuta())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	

	@RequestMapping(method = RequestMethod.PUT,value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody Historico historico,@PathVariable Integer id){
		historico.setId_consuta(id);
		return ResponseEntity.noContent().build();
	}
	
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		servico.deletByid(id);
		return ResponseEntity.noContent().build();
	}

	
}
