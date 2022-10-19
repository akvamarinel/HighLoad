package org.itmo.highload.recipe.service;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.exception.EntityNotFoundException;
import org.itmo.highload.recipe.controller.dto.RecipeDto;
import org.itmo.highload.recipe.controller.mapper.RecipeMapper;
import org.itmo.highload.recipe.model.Recipe;
import org.itmo.highload.recipe.repo.RecipeRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class RecipeService {

    private final RecipeRepo recipeRepo;
    private final RecipeMapper recipeMapper;

    public Recipe getOne(UUID id) {
        return recipeRepo.findById(id).orElseThrow(() -> new EntityNotFoundException(Recipe.class, id));
    }

    public List<Recipe> getAll() {
        return recipeRepo.findAll();
    }


    public Recipe update(UUID id, RecipeDto recipeDto) {
        Recipe oldRecipe = getOne(id);
        Recipe recipe = recipeMapper.toModel(recipeDto);
        oldRecipe.setDescr(recipe.getDescr());
        return recipeRepo.save(oldRecipe);
    }

    public void delete(UUID id) {
        Recipe recipe = getOne(id);
        recipeRepo.delete(recipe);
    }

}
