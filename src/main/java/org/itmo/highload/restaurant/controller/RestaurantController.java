package org.itmo.highload.restaurant.controller;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.common.ResponsePage;
import org.itmo.highload.restaurant.controller.mapper.RestaurantMapper;
import org.itmo.highload.restaurant.controller.dto.RestaurantRequestDto;
import org.itmo.highload.restaurant.controller.dto.RestaurantResponseDto;
import org.itmo.highload.restaurant.service.RestaurantService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

    @GetMapping("/restaurant")
    public ResponseEntity<?> getAll(@PageableDefault Pageable pageable) {
        List<RestaurantResponseDto> restaurantResponseDtoList = restaurantService.getAll(pageable).stream()
                .map(restaurantMapper::toDto).collect(Collectors.toList());
        boolean tmp = restaurantService.getAll(pageable).hasNext();
        ResponseEntity.BodyBuilder bodyBuilder = tmp ? ResponseEntity.status(HttpStatus.PARTIAL_CONTENT) : ResponseEntity.status(HttpStatus.CREATED);
        return bodyBuilder.body(new ResponsePage(restaurantResponseDtoList, tmp));
    }

}
