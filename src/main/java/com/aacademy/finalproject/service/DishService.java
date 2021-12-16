package com.aacademy.finalproject.service;

import com.aacademy.finalproject.entity.Dish;

import java.util.Set;

public interface DishService {

    Dish findById(Long id);

    Dish save(Dish dish);

    Set<Dish> findAll();

    Dish update(Dish  dish, Long id);

    void detachDishIngredient(Long dishId, Set<Long> ingredientsIds);
}
