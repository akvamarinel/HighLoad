package org.itmo.highload.service;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.exception.EntityNotFoundException;
import org.itmo.highload.model.Recipe;
import org.itmo.highload.repo.RecipeRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class RecipeService {

    private final RecipeRepo recipeRepo;

    public Recipe getOne(UUID id) {
        return recipeRepo.findById(id).orElseThrow(() -> new EntityNotFoundException(Recipe.class, id));
    }

    public List<Recipe> getAll() {
        return recipeRepo.findAll();
    }

    public Recipe create(Recipe recipe) {
        return recipeRepo.save(recipe);
    }

    public Recipe update(UUID id, Recipe recipe) {
        Recipe oldRecipe = recipeRepo.findById(id).orElseThrow(() -> new EntityNotFoundException(Recipe.class, id));
        oldRecipe.setDescr(recipe.getDescr());
        return recipeRepo.save(oldRecipe);
    }


    public void delete(UUID id) {
        Recipe recipe = recipeRepo.findById(id).orElseThrow(() -> new EntityNotFoundException(Recipe.class, id));
        recipeRepo.delete(recipe);
    }
}
