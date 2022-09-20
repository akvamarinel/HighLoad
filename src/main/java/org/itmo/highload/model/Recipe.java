package org.itmo.highload.model;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private UUID id;

    @Column(name="recipe", nullable = false)
    private String recipe;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public List<FoodInRecipe> getFoodInRecipes() {
        return foodInRecipes;
    }

    public void setFoodInRecipes(List<FoodInRecipe> foodInRecipes) {
        this.foodInRecipes = foodInRecipes;
    }

    public Recipe(UUID id, String recipe, Dish dish, List<FoodInRecipe> foodInRecipes) {
        this.id = id;
        this.recipe = recipe;
        this.dish = dish;
        this.foodInRecipes = foodInRecipes;
    }

    public Recipe() {
    }

    @OneToOne(mappedBy = "recipe")
    private Dish dish;

    @OneToMany(mappedBy = "recipe")
    private List<FoodInRecipe> foodInRecipes;
}
