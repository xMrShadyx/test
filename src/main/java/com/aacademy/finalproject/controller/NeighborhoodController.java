package com.aacademy.finalproject.controller;

import com.aacademy.finalproject.converter.NeighborhoodConverter;
import com.aacademy.finalproject.dto.NeighborhoodDto;
import com.aacademy.finalproject.service.NeighborhoodService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/neighborhoods")
public class NeighborhoodController {

    private final NeighborhoodService neighborhoodService;
    private final NeighborhoodConverter neighborhoodConverter;

    public NeighborhoodController(NeighborhoodService neighborhoodService, NeighborhoodConverter neighborhoodConverter) {
        this.neighborhoodService = neighborhoodService;
        this.neighborhoodConverter = neighborhoodConverter;
    }

    @PostMapping
    public ResponseEntity<NeighborhoodDto> save(@RequestBody NeighborhoodDto neighborhoodDto) {
        return ResponseEntity.ok(neighborhoodConverter
                .toNeighborhoodDto(neighborhoodService
                        .save(neighborhoodConverter
                                .toNeighborhood(neighborhoodDto))));
    }
}
