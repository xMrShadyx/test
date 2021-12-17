package com.aacademy.finalproject.service;

import com.aacademy.finalproject.entity.Town;

import java.util.Set;

public interface TownService {

    Town findById(Long id);

    Town findByName(String name);

    Town save(Town town);

    Set<Town> findAll();

    Town update(Town town, Long id);

    void detachNeighborhood(Long townId, Set<Long> neighborhoodIds);

    void delete(Long id);
}
