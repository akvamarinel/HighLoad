package org.itmo.highload.repo;

import org.itmo.highload.model.FoodInRecipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FoodInRecipeRepo extends CrudRepository<FoodInRecipe, UUID> {
}
