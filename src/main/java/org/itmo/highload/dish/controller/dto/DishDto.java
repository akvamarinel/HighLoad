package org.itmo.highload.dish.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.itmo.highload.recipe.controller.dto.RecipeDto;

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
public class DishDto {
    private UUID id;

    @NotNull
    @NotBlank
    @NotEmpty
    private String name;

    @NotNull
    private RecipeDto recipe;

    @NotNull
    private UUID restaurantId;

    @NotNull
    @NotEmpty
    private List<UUID> categories = new ArrayList<>();
}
