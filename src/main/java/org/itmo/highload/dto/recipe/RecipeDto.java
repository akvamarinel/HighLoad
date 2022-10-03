package org.itmo.highload.dto.recipe;

import org.itmo.highload.dto.foodinrecipe.FoodInRecipeDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

public class RecipeDto {

    private UUID id;

    @NotEmpty
    @NotBlank
    @NotEmpty
    private String descr;

    @NotNull
    private UUID dishId;

    @NotNull
    private List<FoodInRecipeDto> foodInRecipe;

}
