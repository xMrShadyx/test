package com.aacademy.finalproject.converter;

import com.aacademy.finalproject.dto.TownDto;
import com.aacademy.finalproject.entity.Neighborhood;
import com.aacademy.finalproject.entity.Town;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class TownConverter {

    public TownDto toTownDto(Town town) {
        return TownDto.builder()
                .id(town.getId())
                .name(town.getName())
                .neighborhoodIds(town.getNeighborhoods()
                        .stream()
                        .map(Neighborhood::getId)
                        .collect(Collectors.toSet()))
                .build();
    }


    public Town toTown(TownDto townDto) {
        return Town.builder()
                .id(townDto.getId())
                .name(townDto.getName())
                .neighborhoods(townDto.getNeighborhoodIds().stream()
                        .map((neighborhoodId) -> Neighborhood.builder().id(neighborhoodId)
                                .build())
                        .collect(Collectors.toSet()))
                .build();
    }


}
