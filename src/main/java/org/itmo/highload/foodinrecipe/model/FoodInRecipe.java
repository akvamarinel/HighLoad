package org.itmo.highload.foodinrecipe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.itmo.highload.foodstuff.model.Foodstuff;
import org.itmo.highload.recipe.model.Recipe;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "food_in_recipe")
public class FoodInRecipe {

    @EmbeddedId
    private FoodInRecipeKey id;

    @ManyToOne
    @MapsId("recipeId")
    @JoinColumn(name = "recipe_id", nullable = false)
    private Recipe recipe;

    @ManyToOne
    @MapsId("foodstuffId")
    @JoinColumn(name = "foodstuff_id", nullable = false)
    private Foodstuff foodstuff;

    @Column(name = "weight", nullable = false)
    private Integer weight;
}
