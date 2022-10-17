package org.itmo.highload.foodinrecipe.service;


import lombok.RequiredArgsConstructor;
import org.itmo.highload.exception.EntityNotFoundException;
import org.itmo.highload.foodinrecipe.model.FoodInRecipe;
import org.itmo.highload.foodinrecipe.model.FoodInRecipeKey;
import org.itmo.highload.foodinrecipe.repo.FoodInRecipeRepo;
import org.springframework.stereotype.Service;

import java.nio.BufferUnderflowException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FoodInRecipeService {

    private final FoodInRecipeRepo foodInRecipeRepo;

    public List<FoodInRecipe> getAll() {
        return foodInRecipeRepo.findAll();
    }

    public FoodInRecipe getOne(FoodInRecipeKey key) {
        return foodInRecipeRepo.findById(key).orElseThrow(() -> new EntityNotFoundException(FoodInRecipe.class, key.getRecipeId()));
    }

    public FoodInRecipe create(FoodInRecipe foodInRecipe) {
        if (foodInRecipeRepo.existsById(foodInRecipe.getId())) {
            // fixme
            throw new RuntimeException("Already exists");
        }
        return foodInRecipeRepo.save(foodInRecipe);
    }
}
