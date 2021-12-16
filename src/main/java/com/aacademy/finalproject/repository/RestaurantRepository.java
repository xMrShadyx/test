package com.aacademy.finalproject.repository;

import com.aacademy.finalproject.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
