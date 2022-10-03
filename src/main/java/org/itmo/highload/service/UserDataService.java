package org.itmo.highload.service;

import lombok.AllArgsConstructor;
import org.itmo.highload.dto.UserDataDto;
import org.itmo.highload.model.UserData;
import org.itmo.highload.repo.UserDataRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class UserDataService {



    ModelMapper modelMapper = new ModelMapper();

    private UserDataRepo userDataRepo;

    public void create(UserDataDto userDataDto) {
        UserData userData = modelMapper.map(userDataDto, UserData.class);
        userDataRepo.save(userData);
    }

    public void delete(UserDataDto userDataDto) {
        UserData userData = modelMapper.map(userDataDto, UserData.class);
        userDataRepo.delete(userData);
    }

}
