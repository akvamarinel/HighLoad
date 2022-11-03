package org.itmo.highload.delivery.service;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.delivery.controller.mapper.DeliveryMapper;
import org.itmo.highload.delivery.model.Delivery;
import org.itmo.highload.delivery.repo.DeliveryRepo;
import org.itmo.highload.userdata.model.UserData;
import org.itmo.highload.userdata.repo.UserDataRepo;
import org.itmo.highload.userdata.service.UserDataService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class DeliveryService {

    private final UserDataService userDataService;
    private final DeliveryRepo deliveryRepo;
    private final UserDataRepo userDataRepo;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Delivery create(Delivery delivery) {
        UserData userData = delivery.getUserData();
        userData.setPassword(passwordEncoder.encode(userData.getPassword()));
        if (!userDataService.existsByLogin(userData.getLogin())) {
            userDataRepo.save(userData);
            return deliveryRepo.save(delivery);
        } else {
            return null;
        }
    }
}
