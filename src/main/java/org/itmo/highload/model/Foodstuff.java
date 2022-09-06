package org.itmo.highload.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "foodstuff")
public class Foodstuff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private UUID id;

    private String name;

    public Foodstuff() {
    }

    public Foodstuff(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    @OneToMany(mappedBy = "foodstuff")
    private List<Recipe> recipes;
}
