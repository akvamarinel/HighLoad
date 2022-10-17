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
@NoArgsConstructor
@Getter
@Setter
public class RecipeDto {
    private UUID id;

    @NotEmpty
    @NotBlank
    @NotEmpty
    private String descr;


}
