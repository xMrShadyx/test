package com.aacademy.finalproject.converter;

import com.aacademy.finalproject.dto.RestaurantDto;
import com.aacademy.finalproject.entity.Dish;
import com.aacademy.finalproject.entity.Restaurant;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RestaurantConverter {


    public RestaurantDto toRestaurantDto(Restaurant restaurant) {
        return RestaurantDto.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .dishIds(restaurant.getDishes()
                        .stream().map(Dish::getId)
                        .collect(Collectors.toSet()))
                .build();
    }

    public Restaurant toRestaurant(RestaurantDto restaurantDto) {
        return Restaurant.builder()
                .id(restaurantDto.getId())
                .name(restaurantDto.getName())
                .dishes(restaurantDto.getDishIds().stream()
                        .map((dishId) -> Dish.builder().id(dishId).build())
                        .collect(Collectors.toSet()))
                .build();
    }
}
