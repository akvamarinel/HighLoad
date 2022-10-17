package org.itmo.highload.dish.repo;

import org.itmo.highload.dish.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DishRepo extends JpaRepository<Dish, UUID> {
}
