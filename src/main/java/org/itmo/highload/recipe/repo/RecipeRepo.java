package org.itmo.highload.recipe.repo;


import org.itmo.highload.recipe.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RecipeRepo extends JpaRepository<Recipe, UUID> {
}

