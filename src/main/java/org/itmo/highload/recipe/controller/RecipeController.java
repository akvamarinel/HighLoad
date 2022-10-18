package org.itmo.highload.recipe.controller;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.common.ResponsePage;
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
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class RecipeController {
    private final RecipeService recipeService;
    private final RecipeMapper recipeMapper;
    private final FoodInRecipeService foodInRecipeService;
    private final FoodInRecipeMapper foodInRecipeMapper;
    private final FoodstuffService foodstuffService;

    @GetMapping("/recipe/{id}")
    ResponseEntity<RecipeDto> getOne(@PathVariable UUID id) {
        return ResponseEntity.ok(recipeMapper.toDto(recipeService.getOne(id)));
    }

    @GetMapping("/recipes")
    ResponseEntity<?> getAll(@PageableDefault Pageable pageable) {
        List<FoodInRecipeDto> foodInRecipeDtoList = foodInRecipeService.getAll(pageable).stream()
                .map(foodInRecipeMapper::toDto).collect(Collectors.toList());
        boolean tmp = foodstuffService.getAll(pageable).hasNext();
        ResponseEntity.BodyBuilder bodyBuilder = tmp ? ResponseEntity.status(HttpStatus.PARTIAL_CONTENT) : ResponseEntity.status(HttpStatus.OK);
        return bodyBuilder.body(new ResponsePage(foodInRecipeDtoList, tmp));
    }

    @PutMapping("/recipe/{id}")
    ResponseEntity<RecipeDto> update(@PathVariable UUID id, @Valid @RequestBody RecipeDto recipeDto) {
        return ResponseEntity.ok(recipeMapper.toDto(recipeService.update(id, recipeDto)));
    }

    @DeleteMapping("/recipe/{id}")
    ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        recipeService.delete(id);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/recipe/{id}/food_in_recipe")
    ResponseEntity<?> getFoodInRecipe(@PathVariable UUID id, @PageableDefault Pageable pageable) {
        List<FoodInRecipeDto> foodInRecipeDtoList = foodInRecipeService.getByRecipeId(id, pageable).stream()
                .map(foodInRecipeMapper::toDto).collect(Collectors.toList());
        if (foodInRecipeDtoList.isEmpty()) {
            throw new RuntimeException("Bad request");
        }
        boolean tmp = foodInRecipeService.getByRecipeId(id, pageable).hasNext();
        ResponseEntity.BodyBuilder bodyBuilder = tmp ? ResponseEntity.status(HttpStatus.PARTIAL_CONTENT) : ResponseEntity.status(HttpStatus.OK);
        return bodyBuilder.body(new ResponsePage(foodInRecipeDtoList, tmp));

    }

    @PutMapping("/recipe/{id}/food_in_recipe")
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

    @DeleteMapping("/recipe/{recipeId}/food_in_recipe/{foodstuffId}")
    ResponseEntity<Void> deleteFoodInRecipe(@PathVariable UUID recipeId, @PathVariable UUID foodstuffId) {
        FoodInRecipeKey key = new FoodInRecipeKey(foodstuffId, recipeId);
        foodInRecipeService.deleteById(key);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
