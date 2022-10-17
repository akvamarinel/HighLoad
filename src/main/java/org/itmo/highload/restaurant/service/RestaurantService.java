package org.itmo.highload.restaurant.service;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.exception.EntityNotFoundException;
import org.itmo.highload.restaurant.model.Restaurant;
import org.itmo.highload.restaurant.repo.RestaurantRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class RestaurantService {
    private final RestaurantRepo restaurantRepo;

    @Transactional
    public Restaurant create(Restaurant restaurant) {
        restaurant.setId(UUID.randomUUID());
        return restaurantRepo.save(restaurant);
    }

    public Restaurant getOne(UUID id) {
        return restaurantRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Restaurant.class, id));
    }

    public Page<Restaurant> getAll(Pageable pageable) {
        return restaurantRepo.findAll(pageable);
    }

    @Transactional
    public void delete(UUID id) {
        restaurantRepo.deleteById(getOne(id).getId());
    }
}