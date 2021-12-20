package com.aacademy.finalproject.controller;

import com.aacademy.finalproject.converter.IngredientConverter;
import com.aacademy.finalproject.dto.IngredientDto;
import com.aacademy.finalproject.entity.Ingredient;
import com.aacademy.finalproject.service.IngredientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/ingredient")
@AllArgsConstructor
public class IngredientController {

    private final IngredientService ingredientService;
    private final IngredientConverter ingredientConverter;

    @PostMapping
    public ResponseEntity<IngredientDto> save(@RequestBody IngredientDto ingredientDto) {
        Ingredient ingredient = ingredientConverter.toIngredient(ingredientDto);
        Ingredient savedIngredient = ingredientService.save(ingredient);
        return ResponseEntity.ok(ingredientConverter.toIngredientDto(savedIngredient));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<IngredientDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(ingredientConverter.toIngredientDto(ingredientService.findById(id)));
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<IngredientDto> findByName(@PathVariable String name) {
        return ResponseEntity.ok(ingredientConverter.toIngredientDto(ingredientService.findByName(name)));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        ingredientService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<IngredientDto> update(@RequestBody IngredientDto ingredientDto,
                                                @PathVariable Long id) {
        Ingredient ingredient = ingredientConverter.toIngredient(ingredientDto);
        Ingredient savedIngredient = ingredientService.update(ingredient, id);
        IngredientDto ingredientDtoResponse = ingredientConverter.toIngredientDto(savedIngredient);
        return ResponseEntity.ok(ingredientDtoResponse);

    }



}
