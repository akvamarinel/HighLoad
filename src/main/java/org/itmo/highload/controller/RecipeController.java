package org.itmo.highload.controller;

import lombok.AllArgsConstructor;
import org.itmo.highload.model.Recipe;
import org.itmo.highload.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
public class RecipeController {


    private final RecipeService recipeService;


    @GetMapping("/recipes/{id}")
    ResponseEntity<Recipe> getOne(@PathVariable UUID id) {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/recipes")
    ResponseEntity<List<Recipe>> getAll() {
        return ResponseEntity.ok(null);
    }

    @PostMapping("/recipes")
    ResponseEntity<Recipe> create(@RequestBody Recipe recipe) {
        return ResponseEntity.ok(null);
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
