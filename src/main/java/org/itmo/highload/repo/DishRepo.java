package org.itmo.highload.repo;

import org.itmo.highload.model.Dish;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface DishRepo extends CrudRepository<Dish, UUID> {
}
