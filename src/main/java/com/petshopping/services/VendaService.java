package com.petshopping.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.petshopping.domain.Produtos;
import com.petshopping.domain.Servicos;
import com.petshopping.domain.Venda;
import com.petshopping.repositores.ProdutoRepositores;
import com.petshopping.repositores.ServicoRepositores;
import com.petshopping.repositores.VendaRepositores;
import com.petshopping.service.Exception.ObejectNotFoudException;

@Service
public class VendaService {

	@Autowired
	private VendaRepositores repo;
	
	
	@Autowired
	private ProdutoRepositores produtorepo;
	
	@Autowired
	
	private ServicoRepositores servicoRepositores;

	public Page<Venda> listarvenda(Integer page, Integer size, String direction, String orderBy) {
		PageRequest pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public Venda buscarvenda(Integer id) {
		Optional<Venda> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObejectNotFoudException( "Venda não encontrado. Id: "+id));
	}

	public Venda save(Venda venda) {
		
	
		
		
		return repo.save(venda);

	}

	public Venda update(Venda venda) {
	   
		return repo.save(venda);

		
		
		
		 
	}

	public void deletByid(Integer id) {
		repo.deleteById(id);
	}
}
