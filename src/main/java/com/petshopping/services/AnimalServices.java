package com.petshopping.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshopping.domain.Animal;
import com.petshopping.repositores.AnimalRepositores;

@Service
public class AnimalServices {
	@Autowired
	private AnimalRepositores repo;

	
	
	
	public Animal buscar(Integer id) {
		Optional<Animal> obj = repo.findById(id);
		
		return obj.orElse(null);
	}
	
}
