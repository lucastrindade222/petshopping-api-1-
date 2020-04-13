package com.petshopping.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshopping.domain.Produtos;
import com.petshopping.repositores.ProdutoRepositores;
import com.petshopping.service.Exception.ObejectNotFoudException;;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepositores repo;

	public List<Produtos> listarproduto(){
		return repo.findAll();
	}
	
	
   public Produtos buscar(Integer id) {
	   Optional<Produtos> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObejectNotFoudException( "Evento não encontrado. Id: "+id));
   }
	
   public Produtos save(Produtos produto) {
	   return repo.save(produto);
   }
   public Produtos update(Produtos produto) {
	   return repo.save(produto);
   }
	public void deletByid(Integer id) {
		repo.deleteById(id);
	}
}
