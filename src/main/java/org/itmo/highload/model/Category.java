package org.itmo.highload.model;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="category")
public class Category {
    public Category() {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "categories")
    private List<Dish> dishes;

    public Category(UUID id, String name, List<Dish> dishes) {
        this.id = id;
        this.name = name;
        this.dishes = dishes;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
}