package com.aacademy.finalproject.controller;

import com.aacademy.finalproject.converter.DishConverter;
import com.aacademy.finalproject.dto.DishDetachIngredientDto;
import com.aacademy.finalproject.dto.DishDto;
import com.aacademy.finalproject.entity.Dish;
import com.aacademy.finalproject.service.DishService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/dishes")
@AllArgsConstructor
public class DishController {

    private final DishService dishService;
    private final DishConverter dishConverter;


    @GetMapping(value = "/{id}")
    public ResponseEntity<DishDto> findById(@PathVariable Long id) {
        Dish foundDish = dishService.findById(id);
        DishDto dishDto = dishConverter.toDishDto(foundDish);
        return ResponseEntity.ok(dishDto);
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<DishDto> findByName(@PathVariable String name) {
        return ResponseEntity.ok(dishConverter.toDishDto(dishService.findByName(name)));
    }

    @GetMapping
    public ResponseEntity<Set<DishDto>> findAll() {
        return ResponseEntity.ok(dishService.findAll()
                .stream()
                .map(dishConverter::toDishDto)
                .collect(Collectors.toSet()));
    }


    @PostMapping
    public ResponseEntity<DishDto> save(@RequestBody DishDto dishDto) {

        Dish dish = dishConverter.toDish(dishDto);
        Dish savedDish = dishService.save(dish);
        DishDto dishDtoResponse = dishConverter.toDishDto(savedDish);
        return ResponseEntity.ok(dishDtoResponse);
    }

    @PutMapping(value = "/detach")
    public ResponseEntity<HttpStatus> detach(@RequestBody DishDetachIngredientDto dishDetachIngredientDto) {

        dishService.detachDishIngredient(dishDetachIngredientDto.getDishId(), dishDetachIngredientDto.getIngredientIds());
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<DishDto> update(@RequestBody DishDto dishDto,
                                          @PathVariable Long id) {
        Dish dish = dishConverter.toDish(dishDto);
        Dish savedDish = dishService.update(dish, id);
        DishDto dishDtoResponse = dishConverter.toDishDto(savedDish);
        return ResponseEntity.ok(dishDtoResponse);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {

        dishService.delete(id);
        return ResponseEntity.ok().build();
    }

}
