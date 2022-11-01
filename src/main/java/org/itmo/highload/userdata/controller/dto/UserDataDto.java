package org.itmo.highload.userdata.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.itmo.highload.userdata.model.UserRole;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDataDto {

    UUID id;

    @NotNull
    @NotBlank
    @NotEmpty
    String name;

    @NotNull
    @NotBlank
    @NotEmpty
    String surname;

    @NotNull
    @NotBlank
    @NotEmpty
    String login;

    String password;

    UserRole role;
}
