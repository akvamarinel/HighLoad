package org.itmo.highload.dto.restaurant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.itmo.highload.dto.dish.DishDto;

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
