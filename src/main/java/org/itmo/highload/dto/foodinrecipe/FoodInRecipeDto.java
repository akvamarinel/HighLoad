package org.itmo.highload.dto.foodinrecipe;


import javax.validation.constraints.NotNull;
import java.util.UUID;

public class FoodInRecipeDto {
    @NotNull
    private UUID foodId;
    @NotNull
    private Integer weight;

}





