package org.itmo.highload.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class FoodInRecipeKey implements Serializable {
    @Column(name = "foodstuff_id", nullable = false)
    private UUID foodstuffId;

    @Column(name = "recipe_id", nullable = false)
    private UUID recipeId;

    public FoodInRecipeKey() {
    }

    public UUID getFoodstuffId() {
        return foodstuffId;
    }

    public void setFoodstuffId(UUID foodstuffId) {
        this.foodstuffId = foodstuffId;
    }

    public UUID getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(UUID recipeId) {
        this.recipeId = recipeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodInRecipeKey that = (FoodInRecipeKey) o;
        return Objects.equals(foodstuffId, that.foodstuffId) && Objects.equals(recipeId, that.recipeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(foodstuffId, recipeId);
    }

}
