package org.itmo.highload.restaurant.controller.mapper;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.dish.controller.mapper.DishMapper;
import org.itmo.highload.dish.model.Dish;
import org.itmo.highload.restaurant.controller.dto.RestaurantRequestDto;
import org.itmo.highload.restaurant.controller.dto.RestaurantResponseDto;
import org.itmo.highload.restaurant.model.Restaurant;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class RestaurantMapper {

    private final DishMapper dishMapper;

    public RestaurantResponseDto toDto(Restaurant restaurant) {
        RestaurantResponseDto restaurantResponseDto = new RestaurantResponseDto();
        restaurantResponseDto.setName(restaurant.getName());
        restaurantResponseDto.setId(restaurant.getId());
        restaurantResponseDto.setRating(restaurant.getRating());
        restaurantResponseDto.setDishes(restaurant.getDishes()
                .stream().map(Dish::getId).collect(Collectors.toList()));
        return restaurantResponseDto;
    }

    public Restaurant toModel(RestaurantRequestDto restaurantRequestDto) {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(UUID.randomUUID());
        restaurant.setRating(restaurantRequestDto.getRating());
        restaurant.setName(restaurantRequestDto.getName());
        return restaurant;
    }
}
