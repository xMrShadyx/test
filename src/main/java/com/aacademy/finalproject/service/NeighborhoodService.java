package com.aacademy.finalproject.service;

import com.aacademy.finalproject.entity.Dish;
import com.aacademy.finalproject.entity.Neighborhood;

import java.util.Set;

public interface NeighborhoodService {

    Neighborhood findByName(String name);

    Neighborhood findById(Long id);

    Set<Neighborhood> findAll();

    Neighborhood save(Neighborhood neighborhood);

    void detachRestaurant(Long restaurantId, Set<Long> restaurantsIds);

    Neighborhood update(Neighborhood  neighborhood, Long id);

    void delete(Long id);
}
