package org.itmo.highload.foodinrecipe.repo;

import org.itmo.highload.foodinrecipe.model.FoodInRecipe;
import org.itmo.highload.foodinrecipe.model.FoodInRecipeKey;
import org.itmo.highload.recipe.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface FoodInRecipeRepo extends JpaRepository<FoodInRecipe, FoodInRecipeKey> {
    List<FoodInRecipe> getFoodInRecipesByRecipeId(UUID id);
}
