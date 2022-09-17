package org.itmo.highload.model;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="user_data")
public class UserData {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="surname", nullable = false)
    private String surname;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private UserRole role;

    @OneToOne(mappedBy = "userData")
    private User user;

    @OneToOne(mappedBy = "userData")
    private Delivery delivery;

    public UserData(UUID id, String name, String surname, UserRole role, User user, Delivery delivery) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.user = user;
        this.delivery = delivery;
    }

    public UserData() {
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

}
