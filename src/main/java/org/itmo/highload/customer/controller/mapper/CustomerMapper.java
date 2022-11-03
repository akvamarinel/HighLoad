package org.itmo.highload.customer.controller.mapper;

import org.apache.catalina.util.CustomObjectInputStream;
import org.itmo.highload.customer.controller.dto.CustomerDto;
import org.itmo.highload.customer.model.Customer;
import org.itmo.highload.delivery.controller.dto.DeliveryDto;
import org.itmo.highload.delivery.model.Delivery;
import org.itmo.highload.userdata.model.UserData;
import org.itmo.highload.userdata.model.UserRole;
import org.itmo.highload.userdata.service.UserDataService;

import java.util.UUID;

public class CustomerMapper {


    public Customer toModel(CustomerDto customerDto) {
        UserData userData = UserData.builder()
                .id(UUID.randomUUID())
                .login(customerDto.getLogin())
                .name(customerDto.getName())
                .surname(customerDto.getSurname())
                .role(UserRole.ROLE_CUSTOMER)
                .password(customerDto.getPassword())
                .build();

        return Customer.builder()
                .id(UUID.randomUUID())
                .userData(userData)
                .address(customerDto.getAddress())
                .build();
    }
}
