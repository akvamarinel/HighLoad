package org.itmo.highload.service;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.model.Recipe;
import org.itmo.highload.repo.RecipeRepo;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepo recipeRepo;


    Optional<Recipe> getOne(UUID id) {
        return recipeRepo.findById(id);
    }

    Iterable<Recipe> getAll() {
        return recipeRepo.findAll();
    }

    Recipe create(Recipe recipe) {
        return recipeRepo.save(recipe);
    }

//    Recipe update(UUID id, Recipe recipe) {
//        recipeRepo.findById(id).map();
//    }

}
