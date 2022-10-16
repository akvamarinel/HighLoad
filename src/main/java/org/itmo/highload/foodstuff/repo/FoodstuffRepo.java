package org.itmo.highload.foodstuff.repo;

import org.itmo.highload.foodstuff.model.Foodstuff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FoodstuffRepo extends JpaRepository<Foodstuff, UUID> {
}
