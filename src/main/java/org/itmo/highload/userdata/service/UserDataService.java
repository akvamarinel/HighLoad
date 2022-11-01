package org.itmo.highload.userdata.service;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.userdata.controller.dto.UserDataDto;
import org.itmo.highload.userdata.model.UserData;
import org.itmo.highload.userdata.repo.UserDataRepo;
import org.springframework.stereotype.Service;

import java.util.UUID;


@RequiredArgsConstructor
@Service
public class UserDataService {

    private final UserDataRepo userDataRepo;


    public UserData register(UserData userData) {
        userData.setId(UUID.randomUUID());
        return userDataRepo.save(userData);
    }

    public void delete(UUID uuid) {

    }


    public void update(UserDataDto userDataDto) {

    }

    public UserData findById(UUID id){
        return null;
    }

}
