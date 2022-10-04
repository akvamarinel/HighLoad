package org.itmo.highload.service;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.exception.EntityNotFoundException;
import org.itmo.highload.model.Recipe;
import org.itmo.highload.repo.RecipeRepo;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class RecipeService {

    private final RecipeRepo recipeRepo;

    public Recipe getOne(UUID id) {
        return recipeRepo.findById(id).orElseThrow(() -> new EntityNotFoundException(Recipe.class, id));
    }

    public Iterable<Recipe> getAll() {
        return recipeRepo.findAll();
    }

    public Recipe create(Recipe recipe) {
        return recipeRepo.save(recipe);
    }


}
