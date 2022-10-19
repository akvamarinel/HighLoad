package org.itmo.highload.userdata.controller;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.userdata.service.UserDataService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController()
@RequestMapping("user-data")
public class UserDataController {

    private final UserDataService userDataService;
}
