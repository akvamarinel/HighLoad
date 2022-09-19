package org.itmo.highload.dto;


import org.itmo.highload.model.UserOrder;

import java.util.List;
import java.util.UUID;

public class CustomerDto {
    private UUID id;
    private UserDataDto userDataDto;
    private List<UserOrder> userOrders;

    public CustomerDto(UUID id, UserDataDto userDataDto, List<UserOrder> userOrders) {
        this.id = id;
        this.userDataDto = userDataDto;
        this.userOrders = userOrders;
    }

    public CustomerDto() {
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

    public List<UserOrder> getOrders() {
        return userOrders;
    }

    public void setOrders(List<UserOrder> userOrders) {
        this.userOrders = userOrders;
    }
}
