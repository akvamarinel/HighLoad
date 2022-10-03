package org.itmo.highload.controller;

import lombok.AllArgsConstructor;
import org.itmo.highload.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("user-data")
public class UserDataController {
    @Autowired
    private UserDataService userDataService;
}
