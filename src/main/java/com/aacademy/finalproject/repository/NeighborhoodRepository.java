package com.aacademy.finalproject.repository;

import com.aacademy.finalproject.entity.Neighborhood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NeighborhoodRepository extends JpaRepository<Neighborhood,Long> {
}
