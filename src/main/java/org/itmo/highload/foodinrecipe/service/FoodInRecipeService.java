package org.itmo.highload.foodinrecipe.service;


import lombok.RequiredArgsConstructor;
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
        //fixme:
        return foodInRecipeRepo.findById(key).orElseThrow(() -> new EntityNotFoundException(FoodInRecipe.class, key.getRecipeId()));
    }

    public void deleteById(FoodInRecipeKey key) {
        if (!foodInRecipeRepo.existsById(key)) {
            // fixme:
            throw new EntityNotFoundException(FoodInRecipe.class, key.getRecipeId());
        }
        foodInRecipeRepo.deleteById(key);
    }

    public List<FoodInRecipe> getByRecipeId(UUID id) {
        return foodInRecipeRepo.getFoodInRecipesByRecipeId(id);
    }




    public FoodInRecipe create(FoodInRecipe foodInRecipe) {
        if (foodInRecipeRepo.existsById(foodInRecipe.getId())) {
            // fixme
            throw new RuntimeException("Already exists");
        }
        return foodInRecipeRepo.save(foodInRecipe);
    }
}
