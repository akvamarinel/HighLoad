package org.itmo.highload.service;

import lombok.AllArgsConstructor;
import org.itmo.highload.exception.EntityNotFoudException;
import org.itmo.highload.model.UserOrder;
import org.itmo.highload.repo.UserOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class UserOrderService {

    @Autowired
    private final UserOrderRepo userOrderRepo;
    @Transactional
    public UUID create(UserOrder userOrder){
        userOrder.setId(UUID.randomUUID());
        return userOrderRepo.save(userOrder).getId();
    }

    public UserOrder getOne(UUID id) {
        return userOrderRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoudException(UserOrder.class, id));
    }

    public Page<UserOrder> getAll(Pageable pageable) {
        return userOrderRepo.findAll(pageable);
    }

    public void delete(UserOrder userOrder) {
        userOrderRepo.deleteById(userOrder.getId());
    }

    public UserOrder update(UUID id, UserOrder userOrder) {
        return null;
    }

}
