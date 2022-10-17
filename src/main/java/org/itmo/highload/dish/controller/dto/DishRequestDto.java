package org.itmo.highload.dish.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.itmo.highload.recipe.controller.dto.RecipeRequestDto;

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
public class DishRequestDto {

    @NotNull
    @NotBlank
    @NotEmpty
    String name;

    @NotNull
    RecipeRequestDto recipe;

    @NotNull
    UUID restaurantId;

    @NotNull
    @NotEmpty
    List<UUID> categories = new ArrayList<>();
}
