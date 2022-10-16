package org.itmo.highload.foodinrecipe.repo;

import org.itmo.highload.foodinrecipe.model.FoodInRecipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FoodInRecipeRepo extends CrudRepository<FoodInRecipe, UUID> {
}
