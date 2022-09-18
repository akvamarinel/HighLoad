package org.itmo.highload.dto;


import org.itmo.highload.model.Order;

import java.util.List;
import java.util.UUID;

public class UserDto {
    private UUID id;
    private UserDataDto userDataDto;
    private List<Order> orders;

    public UserDto(UUID id, UserDataDto userDataDto, List<Order> orders) {
        this.id = id;
        this.userDataDto = userDataDto;
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

    public UserDataDto getUserDataDto() {
        return userDataDto;
    }

    public void setUserDataDto(UserDataDto userDataDto) {
        this.userDataDto = userDataDto;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
