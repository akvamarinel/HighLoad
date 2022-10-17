package org.itmo.highload.delivery.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.itmo.highload.userdata.controller.dto.UserDataDto;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryDto {
    private UUID id;
    @NotNull
    private UserDataDto userDataDto;

}
