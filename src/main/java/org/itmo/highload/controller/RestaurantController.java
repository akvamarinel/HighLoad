package org.itmo.highload.controller;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.dto.restaurant.RestaurantMapper;
import org.itmo.highload.service.RestaurantService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;
    private final RestaurantMapper restaurantMapper;


}
