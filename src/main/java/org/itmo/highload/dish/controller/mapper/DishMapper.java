package org.itmo.highload.dish.controller.mapper;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.category.model.Category;
import org.itmo.highload.category.service.CategoryService;
import org.itmo.highload.dish.controller.dto.DishDto;
import org.itmo.highload.dish.model.Dish;
import org.itmo.highload.recipe.controller.mapper.RecipeMapper;
import org.itmo.highload.restaurant.service.RestaurantService;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DishMapper {

    private final CategoryService categoryService;
    private final RestaurantService restaurantService;

    private final RecipeMapper recipeMapper;
    public DishDto toDto(Dish dish) {
        DishDto dishDto = new DishDto();
        dishDto.setId(dish.getId());
        dishDto.setName(dish.getName());
        dishDto.setRecipe(recipeMapper.toDto(dish.getRecipe()));
        dishDto.setRestaurantId(dish.getRestaurant().getId());
        dishDto.setCategories(dish.getCategories().stream()
                .map(Category::getId).collect(Collectors.toList()));
        return dishDto;
    }

    public Dish toModel(DishDto dishDto) {
        Dish dish = new Dish();
        dish.setId(UUID.randomUUID());
        dish.setName(dishDto.getName());
        dish.setRestaurant(restaurantService.getOne(dishDto.getRestaurantId()));
        dish.setCategories(dishDto.getCategories().stream().map(categoryService::getOne).collect(Collectors.toList()));
        return dish;
    }
}

