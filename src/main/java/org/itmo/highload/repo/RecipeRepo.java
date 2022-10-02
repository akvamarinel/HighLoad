package org.itmo.highload.repo;


import org.itmo.highload.model.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RecipeRepo extends CrudRepository<Recipe, UUID> {
}
