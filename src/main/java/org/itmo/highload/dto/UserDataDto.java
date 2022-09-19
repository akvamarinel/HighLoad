package org.itmo.highload.dto;

import org.itmo.highload.model.UserRole;

import java.util.UUID;

public class UserDataDto {
    UUID id;
    String name;
    String surname;

    UserRole role;

    public UserDataDto(UUID id, String name, String surname, UserRole role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.role = role;
    }

    public UserDataDto() {
    }
}
