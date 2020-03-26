package com.petshopping;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.petshopping.domain.Produtos;
import com.petshopping.repositores.ProdutoRepositores;

@SpringBootApplication
public class PetshoppingApplication implements CommandLineRunner {
  @Autowired
	private ProdutoRepositores res;
	
	public static void main(String[] args) {
		SpringApplication.run(PetshoppingApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		Produtos p1 =new Produtos(null,"sd",1l);
		Produtos p2= new Produtos(null,"sad",32l);
		 
	 res.saveAll(Arrays.asList(p1,p2));
		
		
	}

}
