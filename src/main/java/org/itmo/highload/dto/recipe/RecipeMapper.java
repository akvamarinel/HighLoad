package org.itmo.highload.dto.recipe;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.dto.foodinrecipe.FoodInRecipeDto;
import org.itmo.highload.model.Recipe;
import org.itmo.highload.service.DishService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class RecipeMapper {
    private final DishService dishService;

    RecipeResponseDto toDto(Recipe recipe) {
        RecipeResponseDto dto = new RecipeResponseDto();
        dto.setId(recipe.getId());
        dto.setDescr(recipe.getDescr());
        dto.setDishId(recipe.getDish().getId());
        dto.setFoodInRecipe(recipe.getFoodInRecipe().stream().map(e -> new FoodInRecipeDto(e.getFoodstuff().getId(), e.getWeight())).collect(Collectors.toList()));
        return dto;
    }


    Recipe toModel(RecipeRequestDto dto) {
        return null;
    }

}
