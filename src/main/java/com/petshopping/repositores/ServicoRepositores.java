package com.petshopping.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petshopping.domain.Servicos;
@Repository
public interface ServicoRepositores extends JpaRepository<Servicos,Integer> {

}
