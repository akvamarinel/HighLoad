package org.itmo.highload.recipe.controller;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.foodinrecipe.controller.dto.FoodInRecipeDto;
import org.itmo.highload.foodinrecipe.model.FoodInRecipe;
import org.itmo.highload.foodinrecipe.model.FoodInRecipeKey;
import org.itmo.highload.foodinrecipe.service.FoodInRecipeService;
import org.itmo.highload.foodstuff.model.Foodstuff;
import org.itmo.highload.foodstuff.service.FoodstuffService;
import org.itmo.highload.recipe.controller.mapper.RecipeMapper;
import org.itmo.highload.recipe.controller.dto.RecipeRequestDto;
import org.itmo.highload.recipe.controller.dto.RecipeResponseDto;
import org.itmo.highload.recipe.model.Recipe;
import org.itmo.highload.recipe.service.RecipeService;
import org.springframework.beans.BeanUtils;
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

    @GetMapping("/recipes/{id}")
    ResponseEntity<RecipeResponseDto> getOne(@PathVariable UUID id) {
        return ResponseEntity.ok(recipeMapper.toDto(recipeService.getOne(id)));
    }

    @GetMapping("/recipes")
    ResponseEntity<List<RecipeResponseDto>> getAll() {
        return ResponseEntity.ok(recipeService.getAll().stream().map(recipeMapper::toDto).collect(Collectors.toList()));
    }

    @PutMapping("/recipes/{id}")
    ResponseEntity<RecipeResponseDto> update(@PathVariable UUID id, @Valid @RequestBody RecipeRequestDto recipeDto) {
        Recipe recipe = recipeMapper.toModel(recipeDto);
      //  BeanUtils.copyProperties();
        return ResponseEntity.ok(recipeMapper.toDto(recipeService.update(id, recipe)));
    }



    @DeleteMapping("/recipes/{id}")
    ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        recipeService.delete(id);
        return ResponseEntity.ok().build();
    }
}
