package com.petshopping.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshopping.domain.Animal;
import com.petshopping.repositores.AnimalRepositores;

@Service
public class AnimalServices {
	@Autowired
	private AnimalRepositores repo;

	public List< Animal> listarproduto(){
		return repo.findAll();
	}
	
	
	public Animal buscar(Integer id) {
		Optional<Animal> obj = repo.findById(id);
		
		return obj.orElse(null);
	}
	
	public Animal save(Animal animal) {
		return repo.save(animal);
	}
	public Animal update(Animal animal) {
		return repo.save(animal);
	}
	public void deletByid(Integer id) {
		repo.deleteById(id);
	}
	
}
