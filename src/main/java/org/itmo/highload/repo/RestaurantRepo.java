package org.itmo.highload.repo;

import org.itmo.highload.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RestaurantRepo extends JpaRepository<Restaurant, UUID> {
}
