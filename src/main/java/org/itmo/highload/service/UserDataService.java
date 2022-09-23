package org.itmo.highload.service;

import org.itmo.highload.dto.UserDataDto;
import org.itmo.highload.model.UserData;
import org.itmo.highload.repo.UserDataRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDataService {

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private UserDataRepo userDataRepo;

    public void createUser(UserDataDto userDataDto) {
        UserData userData = modelMapper.map(userDataDto, UserData.class);
        userDataRepo.save(userData);
    }

    public void deleteUser(UserDataDto userDataDto) {
        UserData userData = modelMapper.map(userDataDto, UserData.class);
        userDataRepo.delete(userData);
    }

}
