package com.aacademy.finalproject.controller;

import com.aacademy.finalproject.converter.TownConverter;
import com.aacademy.finalproject.dto.RestaurantDetachDishDto;
import com.aacademy.finalproject.dto.RestaurantDto;
import com.aacademy.finalproject.dto.TownDetachNeighborhoodDto;
import com.aacademy.finalproject.dto.TownDto;
import com.aacademy.finalproject.entity.Restaurant;
import com.aacademy.finalproject.entity.Town;
import com.aacademy.finalproject.service.TownService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/towns")
@AllArgsConstructor
public class TownController {

    private final TownService townService;
    private final TownConverter townConverter;

    @PostMapping
    public ResponseEntity<TownDto> save(@RequestBody TownDto townDto){
        Town town = townConverter.toTown(townDto);
        Town savedTown = townService.save(town);
        TownDto townDtoResponse = townConverter.toTownDto(savedTown);
        return ResponseEntity.ok(townDtoResponse);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TownDto> findById(@PathVariable Long id) {
        Town foundTown = townService.findById(id);
        TownDto townDto = townConverter.toTownDto(foundTown);
        return ResponseEntity.ok(townDto);
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<TownDto> findByName(@PathVariable String name) {
        return ResponseEntity.ok(townConverter.toTownDto(townService.findByName(name)));
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<TownDto> update(@RequestBody TownDto townDto,
                                                @PathVariable Long id) {
        Town town = townConverter.toTown(townDto);
        Town savedTown= townService.update(town, id);

        TownDto townDtoResponse = townConverter.toTownDto(savedTown);
        return ResponseEntity.ok(townDtoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        townService.delete(id);
        return ResponseEntity.ok().build();
    }
}
