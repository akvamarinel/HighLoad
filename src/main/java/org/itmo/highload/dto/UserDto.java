package org.itmo.highload.dto;


import org.itmo.highload.model.Order;

import java.util.List;
import java.util.UUID;

public class UserDto {
    private UUID id;
    private String name;
    private String surname;
    private List<Order> orders;

    public UserDto(UUID id, String name, String surname, List<Order> orders) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.orders = orders;
    }

    public UserDto() {
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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
