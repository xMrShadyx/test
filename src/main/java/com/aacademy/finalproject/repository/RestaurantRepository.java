package com.aacademy.finalproject.repository;

import com.aacademy.finalproject.entity.Dish;
import com.aacademy.finalproject.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Optional<Restaurant> findByName(String name);
}
