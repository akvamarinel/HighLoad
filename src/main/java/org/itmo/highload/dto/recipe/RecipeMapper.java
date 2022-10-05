package org.itmo.highload.dto.recipe;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.dto.foodinrecipe.FoodInRecipeDto;
import org.itmo.highload.model.Recipe;
import org.itmo.highload.service.DishService;
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
