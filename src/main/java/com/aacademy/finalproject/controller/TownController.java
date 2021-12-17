package com.aacademy.finalproject.controller;

import com.aacademy.finalproject.converter.TownConverter;
import com.aacademy.finalproject.dto.TownDto;
import com.aacademy.finalproject.entity.Town;
import com.aacademy.finalproject.service.TownService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/towns")
public class TownController {

    private final TownService townService;
    private final TownConverter townConverter;

    public TownController(TownService townService, TownConverter townConverter) {
        this.townService = townService;
        this.townConverter = townConverter;
    }

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



}
