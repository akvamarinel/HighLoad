package org.itmo.highload.controller;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.service.UserDataService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController("user-data")
public class UserDataController {

    private final UserDataService userDataService;
}
