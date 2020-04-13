package com.petshopping.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshopping.domain.Produtos;
import com.petshopping.domain.Servicos;
import com.petshopping.domain.Venda;
import com.petshopping.repositores.VendaRepositores;
import com.petshopping.service.Exception.ObejectNotFoudException;

@Service
public class VendaService {

	@Autowired
	private VendaRepositores repo;

	public List<Venda> listarvenda() {
		return repo.findAll();
	}

	public Venda buscarvenda(Integer id) {
		Optional<Venda> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObejectNotFoudException( "Evento não encontrado. Id: "+id));
	}

	public Venda save(Venda venda) {
		
	
		if(venda.getProduto() != null) {
			for(Produtos p : venda.getProduto()) {
			p.setVenda_P(venda);
			}
			
		}
		
		if(venda.getServico() != null) {
			for(Servicos s : venda.getServico()) {
			s.setVenda_S(venda);
			}
			venda.setDe_venda(new Date());
		}
		
		return repo.save(venda);

	}

	public Venda update(Venda venda) {
		return repo.save(venda);
	}

	public void deletByid(Integer id) {
		repo.deleteById(id);
	}
}
