package org.itmo.highload.recipe.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.itmo.highload.foodinrecipe.controller.dto.FoodInRecipeDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class RecipeResponseDto {

    @NotNull
    private UUID id;

    @NotEmpty
    @NotBlank
    @NotEmpty
    private String descr;

    @NotNull
    private List<FoodInRecipeDto> foodInRecipe = new ArrayList<>();
}
