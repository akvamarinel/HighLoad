package org.itmo.highload.repo;

import org.itmo.highload.model.FoodInRecipe;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface FoodInRecipeRepo extends CrudRepository<FoodInRecipe, UUID> {
}
