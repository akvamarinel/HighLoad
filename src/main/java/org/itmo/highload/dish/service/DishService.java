package org.itmo.highload.dish.service;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.dish.controller.dto.DishRequestDto;
import org.itmo.highload.dish.controller.mapper.DishMapper;
import org.itmo.highload.exception.EntityNotFoundException;
import org.itmo.highload.dish.model.Dish;
import org.itmo.highload.dish.repo.DishRepo;
import org.itmo.highload.foodinrecipe.model.FoodInRecipe;
import org.itmo.highload.foodinrecipe.model.FoodInRecipeKey;
import org.itmo.highload.foodinrecipe.repo.FoodInRecipeRepo;
import org.itmo.highload.foodstuff.model.Foodstuff;
import org.itmo.highload.foodstuff.repo.FoodstuffRepo;
import org.itmo.highload.recipe.controller.dto.RecipeRequestDto;
import org.itmo.highload.recipe.controller.mapper.RecipeMapper;
import org.itmo.highload.recipe.model.Recipe;
import org.itmo.highload.recipe.repo.RecipeRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DishService {
    private final DishRepo dishRepo;
    private final RecipeMapper recipeMapper;
    private final FoodstuffRepo foodstuffRepo;

    private final FoodInRecipeRepo foodInRecipeRepo;
    private final DishMapper dishMapper;
    private final RecipeRepo recipeRepo;

    public Dish getOne(UUID id) {
        return dishRepo.findById(id).orElseThrow(() -> new EntityNotFoundException(Dish.class, id));
    }

    public List<Dish> getAll() {
        return dishRepo.findAll();
    }

    @Transactional
    public Dish create(DishRequestDto dishRequestDto) {
        Dish dish = dishMapper.toModel(dishRequestDto);
        RecipeRequestDto recipeDto = dishRequestDto.getRecipe();
        Recipe recipe = recipeMapper.toModel(recipeDto);
        List<FoodInRecipe> foodInRecipeList = recipeDto.getFoodInRecipe().stream()
                .map(e -> {
                    Foodstuff food = foodstuffRepo.findById(e.getFoodstuffId())
                            .orElseThrow(() -> new EntityNotFoundException(Foodstuff.class, e.getFoodstuffId()));
                    return FoodInRecipe.builder()
                            .id(new FoodInRecipeKey(food.getId(), recipe.getId()))
                            .foodstuff(food)
                            .recipe(recipe)
                            .weight(e.getWeight())
                            .build();
                }).collect(Collectors.toList());
        recipe.setFoodInRecipe(foodInRecipeList);
        recipeRepo.save(recipe);
        foodInRecipeList.forEach(foodInRecipeRepo::save);
        foodInRecipeList.forEach(fr -> {
            Foodstuff foodstuff = fr.getFoodstuff();
            foodstuff.getFoodInRecipe().add(fr);
            foodstuffRepo.save(foodstuff);
        });

        dish.setRecipe(recipe);
        return dishRepo.save(dish);
    }

}
