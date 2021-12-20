package com.aacademy.finalproject.controller;

import com.aacademy.finalproject.converter.NeighborhoodConverter;
import com.aacademy.finalproject.dto.*;
import com.aacademy.finalproject.entity.Dish;
import com.aacademy.finalproject.entity.Neighborhood;
import com.aacademy.finalproject.service.NeighborhoodService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/neighborhoods")
@AllArgsConstructor
public class NeighborhoodController {

    private final NeighborhoodService neighborhoodService;
    private final NeighborhoodConverter neighborhoodConverter;


    @PostMapping
    public ResponseEntity<NeighborhoodDto> save(@RequestBody NeighborhoodDto neighborhoodDto) {
        return ResponseEntity.ok(neighborhoodConverter
                .toNeighborhoodDto(neighborhoodService
                        .save(neighborhoodConverter
                                .toNeighborhood(neighborhoodDto))));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<NeighborhoodDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(neighborhoodConverter.toNeighborhoodDto(neighborhoodService.findById(id)));
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<NeighborhoodDto> findByName(@PathVariable String name) {
        return ResponseEntity.ok(neighborhoodConverter.toNeighborhoodDto(neighborhoodService.findByName(name)));
    }


    @PutMapping(value = "/detach")
    public ResponseEntity<HttpStatus> detach(@RequestBody NeighborhoodDetachRestaurant neighborhoodDetachRestaurant) {

        neighborhoodService.detachRestaurant(neighborhoodDetachRestaurant.getNeighborhoodId(), neighborhoodDetachRestaurant.getRestaurantIds());
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<NeighborhoodDto> update(@RequestBody NeighborhoodDto neighborhoodDto,
                                                  @PathVariable Long id) {
        Neighborhood neighborhood = neighborhoodConverter.toNeighborhood(neighborhoodDto);
        Neighborhood savedNeighborhood = neighborhoodService.update(neighborhood, id);
        NeighborhoodDto neighborhoodDtoResponse = neighborhoodConverter.toNeighborhoodDto(savedNeighborhood);
        return ResponseEntity.ok(neighborhoodDtoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        neighborhoodService.delete(id);
        return ResponseEntity.ok().build();
    }

}
