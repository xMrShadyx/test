package com.aacademy.finalproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NeighborhoodDto {

    private Long id;

    private String name;

    private Set<Long> restaurantIds;
}
