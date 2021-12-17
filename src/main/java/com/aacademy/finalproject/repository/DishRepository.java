package com.aacademy.finalproject.repository;

import com.aacademy.finalproject.entity.Dish;
import com.aacademy.finalproject.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DishRepository extends JpaRepository<Dish,Long> {
    Optional<Dish> findByName(String name);
}
