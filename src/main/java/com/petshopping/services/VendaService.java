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
		
	
		if(venda.getProduto() != null) {
			for(Produtos p : venda.getProduto()) {
			p.setVenda_P(venda);
			}
			
		}
		
		if(venda.getServico() != null) {
			for(Servicos s : venda.getServico()) {
			s.setVenda_se(venda);
			}
			venda.setDe_venda(new Date());
		}
		
		return repo.save(venda);

	}

	public Venda update(Venda venda) {
		Venda objUpdate = buscarvenda(venda.getId_venda());
		Venda objUpdates = buscarvenda(venda.getId_venda());
		List<Produtos> produtodelet= new ArrayList<Produtos>();
		List<Servicos> servicodelet= new ArrayList<Servicos>();
		
		
		if(venda.getProduto() != null) {
			for(Produtos p : venda.getProduto()) {
				p.setVenda_P(venda);
			}
		}
		
		for(Produtos produtosupdate:objUpdate.getProduto()) {
			boolean is=false;
			
			 for(Produtos p :venda.getProduto()) {
				 if(produtosupdate.getId_produto().equals(p.getId_produto())) {
					 is=true;
				 }
			 }
			 
			 if(!is) {
				produtodelet.add(produtosupdate);
			 }
		}
		
		
////
		
		
		if(venda.getServico() != null) {
			for(Servicos s : venda.getServico()) {
				s.setVenda_se(venda);;
			}
		}
		
		for(Servicos servicosupdate:objUpdates.getServico()) {
			boolean is=false;
			
			 for(Servicos s :venda.getServico()) {
				 if(servicosupdate.getId_servico().equals(s.getId_servico())) {
					 is=true;
				 }
			 }
			 
			 if(!is) {
				servicodelet.add(servicosupdate);
			 }
		}
		
		
		
		
		
		
		
		
		venda = repo.save(venda);
		produtorepo.deleteAll(produtodelet);
		servicoRepositores.deleteAll(servicodelet);
		return venda;

		
		
		
		 
	}

	public void deletByid(Integer id) {
		repo.deleteById(id);
	}
}
