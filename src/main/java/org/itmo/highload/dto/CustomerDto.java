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
}
