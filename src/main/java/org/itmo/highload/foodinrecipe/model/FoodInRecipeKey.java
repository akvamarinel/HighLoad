package org.itmo.highload.foodinrecipe.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

@Embeddable
public class FoodInRecipeKey implements Serializable {
    @Column(name = "foodstuff_id", nullable = false)
    private UUID foodstuffId;

    @Column(name = "recipe_id", nullable = false)
    private UUID recipeId;

}
