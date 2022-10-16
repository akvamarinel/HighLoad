package org.itmo.highload.restaurant.controller;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.restaurant.controller.mapper.RestaurantMapper;
import org.itmo.highload.restaurant.controller.dto.RestaurantRequestDto;
import org.itmo.highload.restaurant.controller.dto.RestaurantResponseDto;
import org.itmo.highload.restaurant.service.RestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;
    private final RestaurantMapper restaurantMapper;

    @GetMapping("/restaurant/{id}")
    public ResponseEntity<RestaurantResponseDto> getOne(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(restaurantMapper.toDto(restaurantService.getOne(id)));
    }

    @PostMapping("/restaurant")
    public ResponseEntity<RestaurantResponseDto> create(@RequestBody @Valid RestaurantRequestDto restaurantRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(restaurantMapper.toDto(restaurantService.create(restaurantMapper.toModel(restaurantRequestDto))));
    }

    @DeleteMapping("/restaurant/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        restaurantService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
