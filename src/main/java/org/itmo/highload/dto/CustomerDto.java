package org.itmo.highload.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.itmo.highload.dto.userdata.UserDataDto;
import org.itmo.highload.model.UserOrder;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private UUID id;
    private UserDataDto userDataDto;
    private List<UserOrder> userOrders;

}
