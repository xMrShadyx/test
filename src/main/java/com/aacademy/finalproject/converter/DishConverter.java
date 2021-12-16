package com.aacademy.finalproject.converter;

import com.aacademy.finalproject.dto.DishDto;
import com.aacademy.finalproject.entity.Dish;
import com.aacademy.finalproject.entity.Ingredient;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class DishConverter {

    public DishDto toDishDto(Dish dish) {

        return DishDto.builder()
                .id(dish.getId())
                .name(dish.getName())
                .ingredientIds(dish.getIngredients()
                        .stream()
                        .map(Ingredient::getId)
                        .collect(Collectors.toSet()))
                .build();
    }

    public Dish toDish(DishDto dishDto) {
        return Dish.builder()
                .id(dishDto.getId())
                .name(dishDto.getName())
                .ingredients(dishDto.getIngredientIds().stream()
                        .map((ingredientId) -> Ingredient.builder().id(ingredientId).build())
                        .collect(Collectors.toSet()))
                .build();

    }
}
