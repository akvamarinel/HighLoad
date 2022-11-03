package org.itmo.highload.userorder.controller.mapper;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.customer.service.CustomerService;
import org.itmo.highload.userorder.controller.dto.UserOrderDto;
import org.itmo.highload.userorder.model.UserOrder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class UserOrderMapper {

    private final CustomerService customerService;

    public UserOrder toModel(UserOrderDto userOrderDto) {
        UserOrder userOrder = new UserOrder();
        userOrder.setId(UUID.randomUUID());
        userOrder.setOrderTime(userOrderDto.getOrderTime());
        userOrder.setCustomer(customerService.getById(userOrderDto.getCustomerId()));
        return userOrder;
    }

    public UserOrderDto toDto(UserOrder userOrder) {
        UserOrderDto userOrderDto = new UserOrderDto();
        userOrderDto.setId(userOrderDto.getId());
        userOrderDto.setOrderTime(userOrderDto.getOrderTime());
        userOrderDto.setCustomerId(userOrderDto.getCustomerId());
        userOrderDto.setDeliveryId(userOrderDto.getDeliveryId());
        return userOrderDto;
    }
}
