package org.itmo.highload.foodinrecipe.repo;

import org.itmo.highload.foodinrecipe.model.FoodInRecipe;
import org.itmo.highload.foodinrecipe.model.FoodInRecipeKey;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FoodInRecipeRepo extends JpaRepository<FoodInRecipe, FoodInRecipeKey> {
    Page<FoodInRecipe> getFoodInRecipesByRecipeId(UUID id, Pageable pageable);
}
