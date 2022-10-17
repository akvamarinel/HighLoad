package org.itmo.highload.restaurant.controller.mapper;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.dish.controller.mapper.DishMapper;
import org.itmo.highload.dish.model.Dish;
import org.itmo.highload.restaurant.controller.dto.RestaurantDto;
import org.itmo.highload.restaurant.model.Restaurant;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class RestaurantMapper {

    private final DishMapper dishMapper;

    public RestaurantDto toDto(Restaurant restaurant) {
        RestaurantDto restaurantResponseDto = new RestaurantDto();
        restaurantResponseDto.setName(restaurant.getName());
        restaurantResponseDto.setId(restaurant.getId());
        restaurantResponseDto.setRating(restaurant.getRating());
        return restaurantResponseDto;
    }

    public Restaurant toModel(RestaurantDto restaurantDto) {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(UUID.randomUUID());
        restaurant.setRating(restaurantDto.getRating());
        restaurant.setName(restaurantDto.getName());
        return restaurant;
    }
}
