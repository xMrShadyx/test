package com.aacademy.finalproject.controller;

import com.aacademy.finalproject.converter.RestaurantConverter;
import com.aacademy.finalproject.dto.RestaurantDetachDishDto;
import com.aacademy.finalproject.dto.RestaurantDto;
import com.aacademy.finalproject.entity.Restaurant;
import com.aacademy.finalproject.service.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/restaurants")
@AllArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;
    private final RestaurantConverter restaurantConverter;

    @PostMapping
    public ResponseEntity<RestaurantDto> save(@RequestBody RestaurantDto restaurantDto) {
        return ResponseEntity.ok(restaurantConverter
                .toRestaurantDto(restaurantService
                        .save(restaurantConverter
                                .toRestaurant(restaurantDto))));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<RestaurantDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(restaurantConverter.toRestaurantDto(restaurantService.findById(id)));
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<RestaurantDto> findByName(@PathVariable String name) {
        return ResponseEntity.ok(restaurantConverter.toRestaurantDto(restaurantService.findByName(name)));
    }


    @PutMapping(value = "/detach")
    public ResponseEntity<HttpStatus> detach(@RequestBody RestaurantDetachDishDto restaurantDetachDishDto) {

        restaurantService.detachDish(restaurantDetachDishDto.getRestaurantId(), restaurantDetachDishDto.getDishIds());
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<RestaurantDto> update(@RequestBody RestaurantDto restaurantDto,
                                                @PathVariable Long id) {
        Restaurant restaurant = restaurantConverter.toRestaurant(restaurantDto);
        Restaurant savedRestaurant = restaurantService.update(restaurant, id);

        RestaurantDto restaurantDtoResponse = restaurantConverter.toRestaurantDto(savedRestaurant);
        return ResponseEntity.ok(restaurantDtoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        restaurantService.delete(id);
        return ResponseEntity.ok().build();
    }
}
