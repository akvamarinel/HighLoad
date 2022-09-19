package org.itmo.highload.dto;


import org.itmo.highload.model.Order;

import java.util.List;
import java.util.UUID;

public class UserDto {
    UUID id;
    UserDataDto userDataDto;
    String address;
    List<Order> orders;


    public UserDto(UUID id, UserDataDto userDataDto, String address, List<Order> orders) {
        this.id = id;
        this.userDataDto = userDataDto;
        this.address = address;
        this.orders = orders;
    }

    public UserDto() {
    }

}