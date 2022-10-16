package org.itmo.highload.foodstuff.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.itmo.highload.foodinrecipe.model.FoodInRecipe;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "foodstuff")
public class Foodstuff {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "calories", nullable = false)
    private Integer calories;

    @OneToMany(mappedBy = "foodstuff")
    private List<FoodInRecipe> foodInRecipe;
}
