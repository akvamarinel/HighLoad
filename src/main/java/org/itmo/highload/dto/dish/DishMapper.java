package org.itmo.highload.dto.dish;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.itmo.highload.dto.category.CategoryDto;
import org.itmo.highload.dto.category.CategoryMapper;
import org.itmo.highload.model.Dish;
import org.itmo.highload.service.FoodstuffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class DishMapper {

    private final FoodstuffService foodstuffService;

    public static DishDto convertToDto(Dish dish) {
        DishDto dishDto = new DishDto();
        dishDto.setId(dish.getId());
        dishDto.setName(dish.getName());
        dishDto.setRecipeId(dish.getRecipe().getId());
        dishDto.setRestaurantId(dish.getRestaurant().getId());
        dishDto.setCategories(dish.getCategories().stream().map(CategoryMapper::convertToDto).collect(Collectors.toList()));
        return dishDto;
    }
}

