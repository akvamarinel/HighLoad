package org.itmo.highload.delivery.controller.mapper;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.delivery.controller.dto.DeliveryDto;
import org.itmo.highload.delivery.model.Delivery;
import org.itmo.highload.userdata.service.UserDataService;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DeliveryMapper {

    private final UserDataService userDataService;
    public DeliveryDto toDto(Delivery delivery) {
        DeliveryDto deliveryDto = new DeliveryDto();
        deliveryDto.setId(delivery.getId());
        //deliveryDto.setUserDataDto(userData);
        return null;
    }

    public Delivery toModel(DeliveryDto deliveryDto) {
        return null;
    }
}
