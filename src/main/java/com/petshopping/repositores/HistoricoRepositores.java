package com.petshopping.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petshopping.domain.Historico;

@Repository
public interface HistoricoRepositores extends JpaRepository<Historico,Integer> {

}
