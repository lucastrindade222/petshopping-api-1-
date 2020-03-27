package com.petshopping.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petshopping.domain.Funcionario;

@Repository
public interface FuncionarioRepositores extends JpaRepository<Funcionario,Integer>{


}
