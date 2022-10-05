package org.itmo.highload.repo;


import org.itmo.highload.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RecipeRepo extends JpaRepository<Recipe, UUID> {
}

