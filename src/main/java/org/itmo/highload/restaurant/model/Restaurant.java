package org.itmo.highload.restaurant.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.itmo.highload.dish.model.Dish;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "restaurant")
public class Restaurant {
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "rating")
    private Integer rating;

//    @OneToMany(mappedBy = "restaurant")
//    private List<Dish> dishes = new ArrayList<>();
}
