package com.petshopping.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petshopping.domain.Endereco;
@Repository
public interface EnderecoRepositores extends JpaRepository<Endereco,Integer> {

}
