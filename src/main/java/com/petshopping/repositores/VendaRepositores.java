package com.petshopping.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petshopping.domain.Venda;
@Repository
public interface VendaRepositores extends JpaRepository<Venda,Integer> {

}
