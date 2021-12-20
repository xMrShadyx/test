package com.aacademy.finalproject.service.impl;

import com.aacademy.finalproject.entity.Restaurant;
import com.aacademy.finalproject.exception.ResourceNotFoundException;
import com.aacademy.finalproject.repository.RestaurantRepository;
import com.aacademy.finalproject.service.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Override
    public Restaurant findByName(String name) {
        return restaurantRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Restaurant with name: %s does not exists", name)));
    }

    @Override
    public Restaurant findById(Long id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Restaurant with id: %s does not exists", id)));
    }

    @Override
    public Set<Restaurant> findAll() {
        return new HashSet<>(restaurantRepository.findAll());
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant update(Restaurant restaurant, Long id) {
        Restaurant foundRestaurant = findById(id);
        Restaurant updatedRestaurant = Restaurant.builder()
                .id(foundRestaurant.getId())
                .name(restaurant.getName())
                .build();
        return save(updatedRestaurant);
    }

    @Override
    public void detachDish(Long dishId, Set<Long> dishIds) {
        Restaurant foundRestaurant = findById(dishId);
        foundRestaurant.getDishes()
                .removeIf(dish -> !dishIds.contains(dish.getId()));
        restaurantRepository.save(foundRestaurant);
    }

    @Override
    public void delete(Long id) {
        restaurantRepository.deleteById(id);
    }
}
