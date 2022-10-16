package org.itmo.highload.dish.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    UUID id;
    @NotNull
    @NotBlank
    @NotEmpty
    String name;
    UUID recipeId;
    UUID restaurantId;
    List<UUID> categories = new ArrayList<>();
}
