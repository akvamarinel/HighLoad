package org.itmo.highload.controller;

import lombok.AllArgsConstructor;
import org.itmo.highload.dto.recipe.RecipeRequestDto;
import org.itmo.highload.model.Dish;
import org.itmo.highload.model.Recipe;
import org.itmo.highload.service.DishService;
import org.itmo.highload.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
public class RecipeController {

    private final RecipeService recipeService;
    private final DishService dishService;

    @GetMapping("/recipes/{id}")
    ResponseEntity<Recipe> getOne(@PathVariable UUID id) {
        return ResponseEntity.ok(recipeService.getOne(id));
    }

    @GetMapping("/recipes")
    ResponseEntity<List<Recipe>> getAll() {
        return ResponseEntity.ok(null);
    }

    @PostMapping("/recipes")
    ResponseEntity<Recipe> create(@RequestBody @Valid RecipeRequestDto recipeDto) {
        Dish dish = dishService.getOne(recipeDto.getDishId());
        Recipe recipe = new Recipe(UUID.randomUUID(), recipeDto.getDescr(), dish, new ArrayList<>());
        return ResponseEntity.ok(recipeService.create(recipe));
    }

    @PutMapping("/recipes/{id}")
    ResponseEntity<Recipe> update(@PathVariable UUID id, @RequestBody Recipe recipe) {
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/recipes/{id}")
    ResponseEntity<Recipe> deleteById(@PathVariable UUID id) {
        return ResponseEntity.ok(null);
    }

}
