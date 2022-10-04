package org.itmo.highload.service;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.exception.EntityNotFoundException;
import org.itmo.highload.model.Restaurant;
import org.itmo.highload.repo.RestaurantRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class RestaurantService {
    private final RestaurantRepo restaurantRepo;
    @Transactional
    public Restaurant create(Restaurant restaurant){
        restaurant.setId(UUID.randomUUID());
        return restaurantRepo.save(restaurant);
    }

    public Restaurant getOne(UUID id){
        return restaurantRepo.findById(id)
                .orElseThrow(()->new EntityNotFoundException(Restaurant.class, id));

    }

}
