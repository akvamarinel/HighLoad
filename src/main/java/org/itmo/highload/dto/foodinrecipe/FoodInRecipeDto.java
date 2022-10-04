package org.itmo.highload.dto.foodinrecipe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodInRecipeDto {
    @NotNull
    private UUID dishId;

    @NotNull
    private Integer weight;
}
