package com.petshopping.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petshopping.domain.Cliente;

public interface ClienteRepositores extends JpaRepository<Cliente,Integer> {

}
