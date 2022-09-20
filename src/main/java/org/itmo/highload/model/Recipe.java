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

    @OneToOne(mappedBy = "recipe")
    private Dish dish;

    @OneToMany(mappedBy = "recipe")
    private List<FoodInRecipe> foodInRecipes;
}
