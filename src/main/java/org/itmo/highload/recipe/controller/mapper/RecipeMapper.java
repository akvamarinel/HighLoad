package org.itmo.highload.recipe.controller.mapper;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.foodinrecipe.controller.mapper.FoodInRecipeMapper;
import org.itmo.highload.recipe.controller.dto.RecipeDto;
import org.itmo.highload.recipe.model.Recipe;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class RecipeMapper {

    public RecipeDto toDto(Recipe recipe) {
        RecipeDto dto = new RecipeDto();
        dto.setId(recipe.getId());
        dto.setDescr(recipe.getDescr());
        return dto;
    }

    public Recipe toModel(RecipeDto dto) {
        Recipe recipe = new Recipe();
        recipe.setId(UUID.randomUUID());
        recipe.setDescr(dto.getDescr());
        return recipe;
    }
}
