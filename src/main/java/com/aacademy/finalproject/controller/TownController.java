package com.aacademy.finalproject.controller;

import com.aacademy.finalproject.converter.TownConverter;
import com.aacademy.finalproject.service.TownService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/towns")
public class TownController {

    private final TownService townService;
    private final TownConverter townConverter;

    public TownController(TownService townService, TownConverter townConverter) {
        this.townService = townService;
        this.townConverter = townConverter;
    }



}
