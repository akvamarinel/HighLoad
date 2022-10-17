package org.itmo.highload.foodinrecipe.service;


import lombok.RequiredArgsConstructor;
import org.itmo.highload.foodinrecipe.model.FoodInRecipe;
import org.itmo.highload.foodinrecipe.repo.FoodInRecipeRepo;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FoodInRecipeService {

    private final FoodInRecipeRepo foodInRecipeRepo;

    List<FoodInRecipe> getAll() {
        return foodInRecipeRepo.findAll();
    }

}
