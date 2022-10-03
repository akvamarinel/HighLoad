package org.itmo.highload.repo;

import org.itmo.highload.model.Foodstuff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FoodstuffRepo extends CrudRepository<Foodstuff, UUID> {
}
