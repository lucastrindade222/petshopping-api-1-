package com.petshopping.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshopping.domain.Produtos;
import com.petshopping.repositores.ProdutoRepositores;;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepositores repo;

	public List<Produtos> listarproduto(){
		return repo.findAll();
	}
	
	
   public Produtos buscar(Integer id) {
	   Optional<Produtos> obj = repo.findById(id);
	   return obj.orElse(null);
   }
	
	
}
