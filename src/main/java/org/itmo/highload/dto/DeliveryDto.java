package org.itmo.highload.dto;

import java.util.UUID;

public class DeliveryDto {
    UUID id;
    UserDataDto userDataDto;

    public DeliveryDto(UUID id, UserDataDto userDataDto) {
        this.id = id;
        this.userDataDto = userDataDto;
    }

    public DeliveryDto() {
    }
}
