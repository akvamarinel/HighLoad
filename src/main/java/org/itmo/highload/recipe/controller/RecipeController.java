package org.itmo.highload.recipe.controller;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.foodinrecipe.controller.dto.FoodInRecipeDto;
import org.itmo.highload.foodinrecipe.controller.mapper.FoodInRecipeMapper;
import org.itmo.highload.foodinrecipe.model.FoodInRecipe;
import org.itmo.highload.foodinrecipe.model.FoodInRecipeKey;
import org.itmo.highload.foodinrecipe.service.FoodInRecipeService;
import org.itmo.highload.foodstuff.model.Foodstuff;
import org.itmo.highload.foodstuff.service.FoodstuffService;
import org.itmo.highload.recipe.controller.mapper.RecipeMapper;
import org.itmo.highload.recipe.controller.dto.RecipeDto;
import org.itmo.highload.recipe.model.Recipe;
import org.itmo.highload.recipe.service.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController()
@RequestMapping("recipes")
public class RecipeController {
    private final RecipeService recipeService;
    private final RecipeMapper recipeMapper;
    private final FoodInRecipeService foodInRecipeService;
    private final FoodInRecipeMapper foodInRecipeMapper;
    private final FoodstuffService foodstuffService;

    @GetMapping("/{id}")
    ResponseEntity<RecipeDto> getOne(@PathVariable UUID id) {
        return ResponseEntity.ok(recipeMapper.toDto(recipeService.getOne(id)));
    }

    @GetMapping()
    ResponseEntity<List<RecipeDto>> getAll() {
        List<Recipe> recipeList = recipeService.getAll();
        return ResponseEntity.ok(recipeList.stream().map(recipeMapper::toDto).collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    ResponseEntity<RecipeDto> update(@PathVariable UUID id, @Valid @RequestBody RecipeDto recipeDto) {
        return ResponseEntity.ok(recipeMapper.toDto(recipeService.update(id, recipeDto)));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        recipeService.delete(id);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/{id}/food_in_recipe")
    ResponseEntity<List<FoodInRecipeDto>> getFoodInRecipe(@PathVariable UUID id) {
        List<FoodInRecipe> foodInRecipe = foodInRecipeService.getByRecipeId(id);
        if (foodInRecipe.isEmpty()) {
            throw new RuntimeException("Bad request");
        }
        List<FoodInRecipeDto> dtos = foodInRecipe.stream().map(foodInRecipeMapper::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @PutMapping("/{id}/food_in_recipe")
    ResponseEntity<FoodInRecipeDto> addFoodInRecipe(@PathVariable UUID id, @Valid @RequestBody FoodInRecipeDto foodInRecipeDto) {
        Recipe recipe = recipeService.getOne(id);
        Foodstuff foodstuff = foodstuffService.getOne(foodInRecipeDto.getFoodstuffId());
        FoodInRecipe foodInRecipe = FoodInRecipe.builder()
                .foodstuff(foodstuff)
                .recipe(recipe)
                .weight(foodInRecipeDto.getWeight())
                .id(new FoodInRecipeKey(foodstuff.getId(), recipe.getId()))
                .build();
        return ResponseEntity.ok(foodInRecipeMapper.toDto(foodInRecipeService.create(foodInRecipe)));
    }

    @DeleteMapping("/{recipeId}/food_in_recipe/{foodstuffId}")
    ResponseEntity<Void> deleteFoodInRecipe(@PathVariable UUID recipeId, @PathVariable UUID foodstuffId) {
        FoodInRecipeKey key = new FoodInRecipeKey(foodstuffId, recipeId);
        foodInRecipeService.deleteById(key);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
