package com.aacademy.finalproject.converter;

import com.aacademy.finalproject.dto.NeighborhoodDto;
import com.aacademy.finalproject.entity.Neighborhood;
import com.aacademy.finalproject.entity.Restaurant;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class NeighborhoodConverter {

    public NeighborhoodDto toNeighborhoodDto(Neighborhood neighborhood) {
        return NeighborhoodDto.builder()
                .id(neighborhood.getId())
                .name(neighborhood.getName())
                .restaurantIds(neighborhood.getRestaurants()
                        .stream()
                        .map(Restaurant::getId)
                        .collect(Collectors.toSet()))
                .build();
    }

    public Neighborhood toNeighborhood(NeighborhoodDto neighborhoodDto) {
        return Neighborhood.builder()
                .id(neighborhoodDto.getId())
                .name(neighborhoodDto.getName())
                .restaurants(neighborhoodDto.getRestaurantIds().stream()
                        .map((restaurantId) -> Restaurant.builder().id(restaurantId)
                                .build())
                        .collect(Collectors.toSet()))
                .build();
    }
}
