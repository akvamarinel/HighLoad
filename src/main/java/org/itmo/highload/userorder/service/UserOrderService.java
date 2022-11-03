package org.itmo.highload.userorder.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.itmo.highload.customer.model.Customer;
import org.itmo.highload.customer.service.CustomerService;
import org.itmo.highload.exception.EntityNotFoundException;
import org.itmo.highload.userdata.model.UserData;
import org.itmo.highload.userdata.service.UserDataService;
import org.itmo.highload.userorder.model.UserOrder;
import org.itmo.highload.userorder.repo.UserOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserOrderService {

    private final UserOrderRepo userOrderRepo;
    private final UserDataService userDataService;
    private final CustomerService customerService;



    @Transactional
    public UserOrder create(Principal principal, UserOrder userOrder) {
        var tmp = principal.getName();
        UserData userData = userDataService.findByLogin(tmp);
        Customer customer = customerService.getByUserDataId(userData.getId());
        userOrder.setCustomer(customer);
        userOrder.setId(UUID.randomUUID());
        return userOrderRepo.save(userOrder);
    }

    public UserOrder getOne(UUID id) {
        return userOrderRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(UserOrder.class, id));
    }

    public Page<UserOrder> getAll(Principal principal, Pageable pageable) {
        var tmp = principal.getName();
        UserData userData = userDataService.findByLogin(tmp);
        return userOrderRepo.getUserOrdersById(userData.getId(), pageable);
    }

    public void delete(UserOrder userOrder) {
        userOrderRepo.deleteById(userOrder.getId());
    }

    public UserOrder update(UUID id, UserOrder userOrder) {
        return null;
    }

}
