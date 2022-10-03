package org.itmo.highload.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DishDto {
    UUID id;
    @NotNull
    @NotBlank
    @NotEmpty
    String name;
    UUID recipeId;
    UUID restaurantId;
    List<CategoryDto> categories;
}
