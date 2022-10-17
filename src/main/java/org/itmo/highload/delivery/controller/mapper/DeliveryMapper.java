package org.itmo.highload.delivery.controller.mapper;

import org.itmo.highload.delivery.controller.dto.DeliveryDto;
import org.itmo.highload.delivery.model.Delivery;
import org.springframework.stereotype.Component;

@Component
public class DeliveryMapper {
    public DeliveryDto toDto(Delivery delivery) {
        DeliveryDto deliveryDto = new DeliveryDto();
        deliveryDto.setId(delivery.getId());
       // deliveryDto.setUserDataDto();
        return null;
    }

    public Delivery toModel(DeliveryDto deliveryDto) {
        return null;
    }
}
