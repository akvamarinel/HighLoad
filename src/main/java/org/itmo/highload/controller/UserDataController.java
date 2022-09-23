package org.itmo.highload.controller;

import org.itmo.highload.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserDataController {
    @Autowired
    UserDataService userDataService;



}
