package com.aacademy.finalproject.service.impl;

import com.aacademy.finalproject.entity.Restaurant;
import com.aacademy.finalproject.entity.Town;
import com.aacademy.finalproject.exception.ResourceNotFoundException;
import com.aacademy.finalproject.repository.TownRepository;
import com.aacademy.finalproject.service.TownService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class TownServiceImpl implements TownService {

    private final TownRepository townRepository;


    @Override
    public Town findById(Long id) {
        return townRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Town with id: %s does not exists", id)));
    }

    @Override
    public Town findByName(String name) {
        return townRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Town with name: %s does not exists", name)));
    }

    @Override
    public Town save(Town town) {
        return townRepository.save(town);
    }

    @Override
    public Set<Town> findAll() {

        return new HashSet<>(townRepository.findAll());
    }

    @Override
    public Town update(Town town, Long id) {
        Town foundTown = findById(id);
        Town updatedTown = Town.builder()
                .id(foundTown.getId())
                .name(town.getName())
                .build();
        return save(updatedTown);
    }

    @Override
    public void detachNeighborhood(Long townId, Set<Long> neighborhoodIds) {
        Town foundTown = findById(townId);
        foundTown.getNeighborhoods()
                .removeIf( neighborhood-> !neighborhoodIds.contains(neighborhood.getId()));
        townRepository.save(foundTown);
    }

    @Override
    public void delete(Long id) {
        townRepository.deleteById(id);
    }
}
