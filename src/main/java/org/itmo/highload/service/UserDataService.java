package org.itmo.highload.service;

import lombok.AllArgsConstructor;
import org.itmo.highload.dto.userdata.UserDataDto;
import org.itmo.highload.model.UserData;
import org.itmo.highload.repo.UserDataRepo;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class UserDataService {

    private UserDataRepo userDataRepo;

    public void create(UserDataDto userDataDto) {
    }

    public void delete(UserDataDto userDataDto) {
    }

}
