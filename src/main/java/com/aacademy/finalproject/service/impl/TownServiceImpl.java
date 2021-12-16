package com.aacademy.finalproject.service.impl;

import com.aacademy.finalproject.entity.Town;
import com.aacademy.finalproject.service.TownService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TownServiceImpl implements TownService {


    @Override
    public Town findById(Long id) {
        return null;
    }

    @Override
    public Town save(Town town) {
        return null;
    }

    @Override
    public Set<Town> findAll() {
        return null;
    }

    @Override
    public Town update(Town town, Long id) {
        return null;
    }

    @Override
    public void detachTownRestaurant(Long townId, Set<Long> restaurantIds) {

    }
}
