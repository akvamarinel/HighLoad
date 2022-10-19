package org.itmo.highload.foodinrecipe.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodInRecipeDto {
    @NotNull
    private UUID foodstuffId;

    @NotNull
    @Min(value = 1, message = "Weight must be greater than zero")
    private Integer weight;
}
