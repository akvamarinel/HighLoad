package org.itmo.highload.restaurant.repo;

import org.itmo.highload.restaurant.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RestaurantRepo extends JpaRepository<Restaurant, UUID> {
}
