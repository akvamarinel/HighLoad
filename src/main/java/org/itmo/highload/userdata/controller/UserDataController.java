package org.itmo.highload.userdata.controller;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.userdata.controller.dto.UserDataDto;
import org.itmo.highload.userdata.controller.mapper.UserDataMapper;
import org.itmo.highload.userdata.model.UserData;
import org.itmo.highload.userdata.model.UserRole;
import org.itmo.highload.userdata.service.UserDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController()
@RequestMapping("user-data")
public class UserDataController {

    private final UserDataService userDataService;
    private final UserDataMapper userDataMapper;

    @PostMapping("/customer/register")
    ResponseEntity<UserDataDto> registerCustomer(@RequestBody @Valid UserDataDto userDataDto) {
        userDataDto.setRole(UserRole.ROLE_USER);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userDataMapper.toDto(userDataService.register(userDataMapper.toModel(userDataDto))));
    }

    @PostMapping("/delivery/register")
    ResponseEntity<UserDataDto> registerDelivery(@RequestBody @Valid UserDataDto userDataDto) {
        userDataDto.setRole(UserRole.ROLE_DELIVERY);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userDataMapper.toDto(userDataService.register(userDataMapper.toModel(userDataDto))));
    }
}