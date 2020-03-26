package com.petshopping.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petshopping.domain.Animal;

public interface AnimalRepositores extends JpaRepository<Animal, Integer> {

}
