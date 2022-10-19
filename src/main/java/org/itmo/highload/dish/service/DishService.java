package org.itmo.highload.dish.service;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.dish.controller.dto.DishDto;
import org.itmo.highload.dish.controller.mapper.DishMapper;
import org.itmo.highload.exception.EntityNotFoundException;
import org.itmo.highload.dish.model.Dish;
import org.itmo.highload.dish.repo.DishRepo;
import org.itmo.highload.recipe.controller.dto.RecipeDto;
import org.itmo.highload.recipe.controller.mapper.RecipeMapper;
import org.itmo.highload.recipe.model.Recipe;
import org.itmo.highload.recipe.repo.RecipeRepo;
import org.itmo.highload.restaurant.repo.RestaurantRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class DishService {
    private final DishRepo dishRepo;
    private final RecipeMapper recipeMapper;
    private final DishMapper dishMapper;
    private final RecipeRepo recipeRepo;
<<<<<<< HEAD
    private final RestaurantRepo restaurantRepo;
=======

>>>>>>> f89148a3ed84a337c4864a5287d0afd1936fef1a

    public Dish getOne(UUID id) {
        return dishRepo.findById(id).orElseThrow(() -> new EntityNotFoundException(Dish.class, id));
    }

    public Page<Dish> getAll(Pageable pageable) {
        return dishRepo.findAll(pageable);
    }

    @Transactional
    public Dish create(DishDto dishDto) {
        Dish dish = dishMapper.toModel(dishDto);
        RecipeDto recipeDto = dishDto.getRecipe();
        Recipe recipe = recipeMapper.toModel(recipeDto);
        dish.setRecipe(recipeRepo.save(recipe));
        return dishRepo.save(dish);

//        Dish dish = dishMapper.toModel(dishDto);
//        RecipeDto recipeDto = dishDto.getRecipe();
//        Recipe recipe = recipeMapper.toModel(recipeDto);
//        List<FoodInRecipe> foodInRecipeList = recipeDto.getFoodInRecipe().stream()
//                .map(e -> {
//                    Foodstuff food = foodstuffRepo.findById(e.getFoodstuffId())
//                            .orElseThrow(() -> new EntityNotFoundException(Foodstuff.class, e.getFoodstuffId()));
//                    return FoodInRecipe.builder()
//                            .id(new FoodInRecipeKey(food.getId(), recipe.getId()))
//                            .foodstuff(food)
//                            .recipe(recipe)
//                            .weight(e.getWeight())
//                            .build();
//                }).collect(Collectors.toList());
//        recipe.setFoodInRecipe(foodInRecipeList);
//        recipeRepo.save(recipe);
//        foodInRecipeList.forEach(foodInRecipeRepo::save);
//        foodInRecipeList.forEach(fr -> {
//            Foodstuff foodstuff = fr.getFoodstuff();
//            foodstuff.getFoodInRecipe().add(fr);
//            foodstuffRepo.save(foodstuff);
//        });
//
//        dish.setRecipe(recipe);
//        return dishRepo.save(dish);
//    }

    }
}
