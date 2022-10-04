package org.itmo.highload.dto.dish;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.dto.category.CategoryMapper;
import org.itmo.highload.model.Dish;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class DishMapper {

    private final CategoryMapper categoryMapper;

    public  DishDto toDto(Dish dish) {
        DishDto dishDto = new DishDto();
        dishDto.setId(dish.getId());
        dishDto.setName(dish.getName());
        dishDto.setRecipeId(dish.getRecipe().getId());
        dishDto.setRestaurantId(dish.getRestaurant().getId());
        dishDto.setCategories(dish.getCategories().stream().map(categoryMapper::toDto).collect(Collectors.toList()));
        return dishDto;
    }
}

