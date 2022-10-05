package org.itmo.highload.dto.dish;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.dto.category.CategoryMapper;
import org.itmo.highload.model.Category;
import org.itmo.highload.model.Dish;
import org.itmo.highload.model.Restaurant;
import org.itmo.highload.service.RecipeService;
import org.itmo.highload.service.RestaurantService;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class DishMapper {

    private final RecipeService recipeService;
    private final RestaurantService restaurantService;


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
        dish.setRecipe(recipeService.getOne(dishRequestDto.getRecipeId()));
        dish.setRestaurant(restaurantService.getOne(dishRequestDto.getRestaurantId()));
        return dish;
    }
}

