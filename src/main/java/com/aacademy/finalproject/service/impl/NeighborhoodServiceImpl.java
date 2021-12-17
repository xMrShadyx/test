package com.aacademy.finalproject.service.impl;

import com.aacademy.finalproject.entity.Neighborhood;
import com.aacademy.finalproject.exception.ResourceNotFoundException;
import com.aacademy.finalproject.repository.NeighborhoodRepository;
import com.aacademy.finalproject.service.NeighborhoodService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class NeighborhoodServiceImpl implements NeighborhoodService {

    private final NeighborhoodRepository neighborhoodRepository;

    public NeighborhoodServiceImpl(NeighborhoodRepository neighborhoodRepository) {
        this.neighborhoodRepository = neighborhoodRepository;
    }

    @Override
    public Neighborhood findByName(String name) {
        return neighborhoodRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Neighbourhood with name: %s does not exists")));
    }

    @Override
    public Neighborhood findById(Long id) {
        return neighborhoodRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Neighborhood with id: %s does not exists")));
    }

    @Override
    public Set<Neighborhood> findAll() {
        return new HashSet<>(neighborhoodRepository.findAll());
    }

    @Override
    public Neighborhood save(Neighborhood neighborhood) {
        return neighborhoodRepository.save(neighborhood);
    }

    @Override
    public Neighborhood update(Neighborhood neighborhood, Long id) {
        Neighborhood foundNeighborhood = findById(id);
        Neighborhood updatedNeighborhood = Neighborhood.builder()
                .id(foundNeighborhood.getId())
                .name(neighborhood.getName())
                .build();
        return save(updatedNeighborhood);
    }

    @Override
    public void delete(Long id) {
        neighborhoodRepository.deleteById(id);
    }

    @Override
    public void detachRestaurant(Long neighborhoodId, Set<Long> restaurantsIds) {
        Neighborhood foundNeighborhood = findById(neighborhoodId);
        foundNeighborhood.getRestaurants()
                .removeIf(restaurant -> !restaurantsIds.contains(restaurant.getId()));
        neighborhoodRepository.save(foundNeighborhood);

    }

}
