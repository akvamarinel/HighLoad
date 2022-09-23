package org.itmo.highload.repo;

import org.itmo.highload.model.Foodstuff;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface FoodstuffRepo extends CrudRepository<Foodstuff, UUID> {
}
