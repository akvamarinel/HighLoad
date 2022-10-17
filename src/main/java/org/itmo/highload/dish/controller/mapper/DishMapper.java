package org.itmo.highload.dish.controller.mapper;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.category.model.Category;
import org.itmo.highload.category.service.CategoryService;
import org.itmo.highload.dish.controller.dto.DishRequestDto;
import org.itmo.highload.dish.controller.dto.DishResponseDto;
import org.itmo.highload.dish.model.Dish;
import org.itmo.highload.recipe.controller.mapper.RecipeMapper;
import org.itmo.highload.recipe.service.RecipeService;
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
    public DishResponseDto toDto(Dish dish) {
        DishResponseDto dishDto = new DishResponseDto();
        dishDto.setId(dish.getId());
        dishDto.setName(dish.getName());
        dishDto.setRecipeId(dish.getRecipe().getId());
        dishDto.setRestaurantId(dish.getRestaurant().getId());
        dishDto.setCategories(dish.getCategories().stream()
                .map(Category::getId).collect(Collectors.toList()));
        return dishDto;
    }

    public Dish toModel(DishRequestDto dishRequestDto) {
        Dish dish = new Dish();
        dish.setId(UUID.randomUUID());
        dish.setName(dishRequestDto.getName());
        dish.setRestaurant(restaurantService.getOne(dishRequestDto.getRestaurantId()));
        dish.setCategories(dishRequestDto.getCategories().stream().map(categoryService::getOne).collect(Collectors.toList()));
        return dish;
    }
}

