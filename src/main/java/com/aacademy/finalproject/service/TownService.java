package com.aacademy.finalproject.service;

import com.aacademy.finalproject.entity.Town;

import java.util.Set;

public interface TownService {

    Town findById(Long id);

    Town save(Town town);

    Set<Town> findAll();

    Town update(Town town, Long id);

    void detachTownRestaurant(Long townId, Set<Long> restaurantIds);
}
