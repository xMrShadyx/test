package com.aacademy.finalproject.converter;

import com.aacademy.finalproject.dto.IngredientDto;
import com.aacademy.finalproject.entity.Ingredient;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;

@Component
public class IngredientConverter {
    public IngredientDto toIngredientDto(Ingredient ingredient) {
        return IngredientDto.builder()
                .id(ingredient.getId())
                .name(ingredient.getName())
                .build();
    }

    public Ingredient toIngredient(IngredientDto ingredientDto) {
        return Ingredient.builder()
                .id(ingredientDto.getId())
                .name(ingredientDto.getName())
                .build();
    }

}
