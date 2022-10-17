package org.itmo.highload.foodinrecipe.controller.mapper;

import org.itmo.highload.foodinrecipe.controller.dto.FoodInRecipeDto;
import org.itmo.highload.foodinrecipe.model.FoodInRecipe;
import org.itmo.highload.foodinrecipe.model.FoodInRecipeKey;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class FoodInRecipeMapper {
    public FoodInRecipeDto toDto(FoodInRecipe foodInRecipe) {
        FoodInRecipeDto dto = new FoodInRecipeDto();
        dto.setWeight(foodInRecipe.getWeight());
        dto.setFoodstuffId(foodInRecipe.getId().getFoodstuffId());
        return dto;
    }
}
