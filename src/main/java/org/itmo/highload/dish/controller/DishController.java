package org.itmo.highload.dish.controller;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.dish.controller.dto.DishDto;
import org.itmo.highload.dish.controller.mapper.DishMapper;
import org.itmo.highload.dish.service.DishService;
import org.itmo.highload.recipe.controller.dto.RecipeDto;
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



    @GetMapping("/dishes/{id}")
    ResponseEntity<DishDto> getOne(@PathVariable UUID id) {
        return ResponseEntity.ok(dishMapper.toDto(dishService.getOne(id)));
    }

    @GetMapping("/dishes")
    ResponseEntity<List<DishDto>> getAll() {
        return ResponseEntity.ok(dishService.getAll().stream().map(dishMapper::toDto).collect(Collectors.toList()));
    }

    @PostMapping("/dishes")
    ResponseEntity<DishDto> create(@RequestBody @Valid DishDto dishDto) {
        return ResponseEntity.ok(dishMapper.toDto(dishService.create(dishDto)));
    }

    @PutMapping("/dishes/{id}")
    ResponseEntity<RecipeDto> update(@PathVariable UUID id, @Valid @RequestBody RecipeDto recipeDto) {
        Recipe recipe = recipeMapper.toModel(recipeDto);
        return ResponseEntity.ok(recipeMapper.toDto(recipeService.update(id, recipe)));
    }

    @DeleteMapping("/dishes/{id}")
    ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        recipeService.delete(id);
        return ResponseEntity.ok().build();
    }
}
