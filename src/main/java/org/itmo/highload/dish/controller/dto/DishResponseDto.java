package org.itmo.highload.dish.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.itmo.highload.recipe.controller.dto.RecipeResponseDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DishResponseDto {

    @NotNull
    private UUID id;

    @NotNull
    @NotBlank
    @NotEmpty
    private String name;

    @NotNull
    private UUID recipeId;

    @NotNull
    private UUID restaurantId;

    @NotNull
    @NotEmpty
    private List<UUID> categories = new ArrayList<>();
}
