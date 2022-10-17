package org.itmo.highload.recipe.controller;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.recipe.controller.mapper.RecipeMapper;
import org.itmo.highload.recipe.controller.dto.RecipeDto;
import org.itmo.highload.recipe.model.Recipe;
import org.itmo.highload.recipe.service.RecipeService;
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
    ResponseEntity<RecipeDto> getOne(@PathVariable UUID id) {
        return ResponseEntity.ok(recipeMapper.toDto(recipeService.getOne(id)));
    }

    @GetMapping("/recipes")
    ResponseEntity<List<RecipeDto>> getAll() {

        List<Recipe> recipeList = recipeService.getAll();
        return ResponseEntity.ok(recipeList.stream().map(recipeMapper::toDto).collect(Collectors.toList()));
    }

    @PutMapping("/recipes/{id}")
    ResponseEntity<RecipeDto> update(@PathVariable UUID id, @Valid @RequestBody RecipeDto recipeDto) {
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
