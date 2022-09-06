package org.itmo.highload.model;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "categories")
    private List<Dish> dishes;

}
