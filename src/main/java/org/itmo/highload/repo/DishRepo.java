package org.itmo.highload.repo;

import org.itmo.highload.model.Dish;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DishRepo extends CrudRepository<Dish, UUID> {
}
