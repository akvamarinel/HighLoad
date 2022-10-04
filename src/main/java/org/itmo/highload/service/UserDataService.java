package org.itmo.highload.service;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.dto.userdata.UserDataDto;
import org.itmo.highload.repo.UserDataRepo;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class UserDataService {

    private final UserDataRepo userDataRepo;

    public void create(UserDataDto userDataDto) {
    }

    public void delete(UserDataDto userDataDto) {
    }
}
