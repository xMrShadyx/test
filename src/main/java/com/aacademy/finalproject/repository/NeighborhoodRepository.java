package com.aacademy.finalproject.repository;

import com.aacademy.finalproject.entity.Dish;
import com.aacademy.finalproject.entity.Neighborhood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NeighborhoodRepository extends JpaRepository<Neighborhood,Long> {
    Optional<Neighborhood> findByName(String name);
}
