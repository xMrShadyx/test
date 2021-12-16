package com.aacademy.finalproject.service.impl;

import com.aacademy.finalproject.entity.Dish;
import com.aacademy.finalproject.service.DishService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class DishServiceImpl implements DishService {


    @Override
    public Dish findById(Long id) {
        return null;
    }

    @Override
    public Dish save(Dish dish) {
        return null;
    }

    @Override
    public Set<Dish> findAll() {
        return null;
    }

    @Override
    public Dish update(Dish dish, Long id) {
        return null;
    }

    @Override
    public void detachDishIngredient(Long dishId, Set<Long> ingredientsIds) {

    }
}
