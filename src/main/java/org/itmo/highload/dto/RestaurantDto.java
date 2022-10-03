package org.itmo.highload.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDto {
    UUID id;
    String name;
    Integer rating;
    List<DishDto> dishes;
}
