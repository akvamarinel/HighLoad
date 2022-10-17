package org.itmo.highload.dish.controller;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.dish.controller.dto.DishRequestDto;
import org.itmo.highload.dish.controller.dto.DishResponseDto;
import org.itmo.highload.dish.controller.mapper.DishMapper;
import org.itmo.highload.dish.model.Dish;
import org.itmo.highload.dish.repo.DishRepo;
import org.itmo.highload.dish.service.DishService;
import org.itmo.highload.recipe.controller.dto.RecipeRequestDto;
import org.itmo.highload.recipe.controller.dto.RecipeResponseDto;
import org.itmo.highload.recipe.controller.mapper.RecipeMapper;
import org.itmo.highload.recipe.model.Recipe;
import org.itmo.highload.recipe.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class DishController {

    private final DishMapper dishMapper;
    private final DishService dishService;
    private final RecipeService recipeService;
    private final RecipeMapper recipeMapper;



    @GetMapping("/dish/{id}")
    ResponseEntity<DishResponseDto> getOne(@PathVariable UUID id) {
        return ResponseEntity.ok(dishMapper.toDto(dishService.getOne(id)));
    }

    @GetMapping("/recipes")
    ResponseEntity<List<DishResponseDto>> getAll() {
        return ResponseEntity.ok(dishService.getAll().stream().map(dishMapper::toDto).collect(Collectors.toList()));
    }

    @PostMapping("/recipes")
    ResponseEntity<DishResponseDto> create(@RequestBody @Valid DishRequestDto dish) {
        Dish newDish = dishMapper.toModel(dish);
        Recipe recipe = recipeService.create(recipeMapper.toModel(dish.getRecipe()));

        return ResponseEntity.ok(recipeMapper.toDto(recipeService.create(recipe)));
    }

    @PutMapping("/recipes/{id}")
    ResponseEntity<RecipeResponseDto> update(@PathVariable UUID id, @Valid @RequestBody RecipeRequestDto recipeDto) {
        Recipe recipe = recipeMapper.toModel(recipeDto);
        return ResponseEntity.ok(recipeMapper.toDto(recipeService.update(id, recipe)));
    }

    @DeleteMapping("/recipes/{id}")
    ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        recipeService.delete(id);
        return ResponseEntity.ok().build();
    }
}
