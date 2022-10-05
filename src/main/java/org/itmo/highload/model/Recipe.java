package org.itmo.highload.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name = "recipe")
public class Recipe {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "descr", nullable = false)
    private String descr;

    @OneToOne(mappedBy = "recipe")
    private Dish dish;

    @OneToMany(mappedBy = "recipe")
    private List<FoodInRecipe> foodInRecipe = new ArrayList<>();
}
