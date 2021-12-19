package com.aacademy.finalproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class NeighborhoodDetachRestaurant {

    private Long neighborhoodId;

    private Set<Long> restaurantIds;
}
