package org.itmo.highload.model;

import javax.persistence.*;

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

    public FoodInRecipe() {
    }

    public FoodInRecipe(FoodInRecipeKey id, Recipe recipe, Foodstuff foodstuff, Integer weight) {
        this.id = id;
        this.recipe = recipe;
        this.foodstuff = foodstuff;
        this.weight = weight;
    }

    public FoodInRecipeKey getId() {
        return id;
    }

    public void setId(FoodInRecipeKey id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Foodstuff getFoodstuff() {
        return foodstuff;
    }

    public void setFoodstuff(Foodstuff foodstuff) {
        this.foodstuff = foodstuff;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "FoodInRecipe{" +
                "id=" + id +
                ", recipe=" + recipe +
                ", foodstuff=" + foodstuff +
                ", weight=" + weight +
                '}';
    }
}
