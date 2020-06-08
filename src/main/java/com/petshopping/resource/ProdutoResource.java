package com.petshopping.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	@RequestMapping(method = RequestMethod.POST)
	@PreAuthorize("hasAnyRole('FUNCIONARIO')")
	public ResponseEntity<Void> salve(@Valid @RequestBody Produtos produto ){
		Produtos obj = service.save(produto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId_produto())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	@RequestMapping(method = RequestMethod.PUT,value = "/{id}")
	@PreAuthorize("hasAnyRole('FUNCIONARIO')")
	public ResponseEntity<Void> update(@RequestBody Produtos produto,@PathVariable Integer id){
		produto.setId_produto(id);
		service.update(produto);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/{id}")
	@PreAuthorize("hasAnyRole('FUNCIONARIO')")
	public ResponseEntity<Void> delet(@PathVariable Integer id){
		service.deletByid(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(value = "/foto/{id}",method = RequestMethod.POST)
	@PreAuthorize("hasAnyRole('FUNCIONARIO')")
	public ResponseEntity<Void> foto(@PathVariable Integer id,@RequestParam("file")MultipartFile multipartFile ){
		
		URI uri = service.uploadFoto(id, multipartFile);
				
		return ResponseEntity.created(uri).build();
	}
	
	

}
