package org.itmo.highload.foodinrecipe.service;


import lombok.RequiredArgsConstructor;
import org.itmo.highload.exception.EntityExistsException;
import org.itmo.highload.exception.EntityNotFoundException;
import org.itmo.highload.foodinrecipe.model.FoodInRecipe;
import org.itmo.highload.foodinrecipe.model.FoodInRecipeKey;
import org.itmo.highload.foodinrecipe.repo.FoodInRecipeRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.nio.BufferUnderflowException;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class FoodInRecipeService {

    private final FoodInRecipeRepo foodInRecipeRepo;

    public Page<FoodInRecipe> getAll(Pageable pageable) {
        return foodInRecipeRepo.findAll(pageable);
    }

    public FoodInRecipe getOne(FoodInRecipeKey key) {
        return foodInRecipeRepo.findById(key).orElseThrow(() -> new EntityNotFoundException(FoodInRecipe.class, key.getRecipeId()));
    }

    public void deleteById(FoodInRecipeKey key) {
        if (!foodInRecipeRepo.existsById(key)) {
            throw new EntityNotFoundException(FoodInRecipe.class, key.getRecipeId());
        }
        foodInRecipeRepo.deleteById(key);
    }

    public Page<FoodInRecipe> getByRecipeId(UUID id, Pageable pageable) {
        return foodInRecipeRepo.getFoodInRecipesByRecipeId(id, pageable);
    }

    public FoodInRecipe create(FoodInRecipe foodInRecipe) {
        if (foodInRecipeRepo.existsById(foodInRecipe.getId())) {
            throw new EntityExistsException(FoodInRecipe.class, foodInRecipe.getId().getRecipeId(), foodInRecipe.getId().getFoodstuffId());
        }
        return foodInRecipeRepo.save(foodInRecipe);
    }
}
