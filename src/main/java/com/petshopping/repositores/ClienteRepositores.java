package com.petshopping.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petshopping.domain.Cliente;
@Repository
public interface ClienteRepositores extends JpaRepository<Cliente,Integer> {

}
