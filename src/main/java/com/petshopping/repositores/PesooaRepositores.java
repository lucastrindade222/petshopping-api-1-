package com.petshopping.repositores;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petshopping.domain.Pessoa;
@Repository
public interface PesooaRepositores extends JpaRepository<Pessoa,Integer> {

	@Transactional
	Pessoa  findByEmail(String email);
	
	
}
