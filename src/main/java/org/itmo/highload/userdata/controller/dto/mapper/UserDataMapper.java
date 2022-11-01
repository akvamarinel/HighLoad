package org.itmo.highload.userdata.controller.mapper;

import org.itmo.highload.userdata.controller.dto.UserDataDto;
import org.itmo.highload.userdata.model.UserData;

import java.util.UUID;

public class UserDataMapper {
    public UserData toModel(UserDataDto userDataDto) {
        UserData userData = new UserData();
        userData.setLogin(userDataDto.getLogin());
        userData.setPassword(userDataDto.getPassword());
        userData.setName(userDataDto.getName());
        userData.setName(userDataDto.getName());
        userData.setRole(userDataDto.getRole());
        return userData;
    }

    public UserDataDto toDto(UserData userData) {
        UserDataDto userDataDto = new UserDataDto();
        userDataDto.setId(userData.getId());
        userDataDto.setName(userData.getName());
        userDataDto.setSurname(userData.getSurname());
        userDataDto.setLogin(userData.getLogin());
        return userDataDto;
    }
}