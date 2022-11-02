package org.itmo.highload.userdata.service;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.userdata.controller.dto.UserDataDto;
import org.itmo.highload.userdata.model.UserData;
import org.itmo.highload.userdata.repo.UserDataRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;


@RequiredArgsConstructor
@Service
public class UserDataService {

    private final UserDataRepo userDataRepo;

    private final PasswordEncoder passwordEncoder;

    public UserData register(UserData userData) {
        userData.setId(UUID.randomUUID());
        return userDataRepo.save(userData);
    }

    public UserData findByLogin(String login) {
        return userDataRepo.findByLogin(login);
    }

    public void delete(UUID uuid) {

    }


    public void update(UserDataDto userDataDto) {

    }

    public UserData findById(UUID id){
        return null;
    }

}
