package org.itmo.highload.dto.customer;


import org.itmo.highload.dto.userdata.UserDataDto;
import org.itmo.highload.model.UserOrder;

import java.util.List;
import java.util.UUID;

public class CustomerDto {
    private UUID id;
    private UUID userDataId;
    private List<UUID> userOrdersIds;

}
