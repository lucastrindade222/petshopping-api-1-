package com.petshopping.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petshopping.domain.Animal;
@Repository
public interface AnimalRepositores extends JpaRepository<Animal, Integer> {

}
