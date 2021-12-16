package com.aacademy.finalproject.service;


import com.aacademy.finalproject.entity.Restaurant;

import java.util.Set;

public interface RestaurantService {

    Restaurant findByName(String name);

    Restaurant findById(Long id);

    Set<Restaurant> findAll();

    Restaurant save(Restaurant restaurant);
}
