package org.itmo.highload.recipe.controller.mapper;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.foodinrecipe.controller.dto.FoodInRecipeDto;
import org.itmo.highload.recipe.controller.dto.RecipeRequestDto;
import org.itmo.highload.recipe.controller.dto.RecipeResponseDto;
import org.itmo.highload.recipe.model.Recipe;
import org.itmo.highload.dish.service.DishService;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class RecipeMapper {

    private final DishService dishService;

    public RecipeResponseDto toDto(Recipe recipe) {
        RecipeResponseDto dto = new RecipeResponseDto();
        dto.setId(recipe.getId());
        dto.setDescr(recipe.getDescr());
        dto.setFoodInRecipe(recipe.getFoodInRecipe().stream().map(e -> new FoodInRecipeDto(e.getFoodstuff().getId(), e.getWeight())).collect(Collectors.toList()));
        return dto;
    }

    public Recipe toModel(RecipeRequestDto dto) {
        Recipe recipe = new Recipe();
        recipe.setId(UUID.randomUUID());
        recipe.setDescr(dto.getDescr());
        return recipe;
    }
}
