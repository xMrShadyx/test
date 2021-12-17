package com.aacademy.finalproject.service;

import com.aacademy.finalproject.entity.Ingredient;



public interface IngredientService {


    Ingredient findByName(String name);

    Ingredient findById(Long id);

    Ingredient save(Ingredient ingredient);

    void delete(Long id);

}
