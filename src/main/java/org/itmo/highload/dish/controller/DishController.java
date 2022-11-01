package org.itmo.highload.dish.controller;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.common.ResponsePage;
import org.itmo.highload.dish.controller.dto.DishDto;
import org.itmo.highload.dish.controller.mapper.DishMapper;
import org.itmo.highload.dish.service.DishService;
import org.itmo.highload.recipe.controller.dto.RecipeDto;
import org.itmo.highload.recipe.controller.mapper.RecipeMapper;
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
@RestController()
@RequestMapping("dishes")
public class DishController {

    private final DishMapper dishMapper;
    private final DishService dishService;
    private final RecipeService recipeService;
    private final RecipeMapper recipeMapper;


    @GetMapping("/{id}")
    ResponseEntity<DishDto> getOne(@PathVariable UUID id) {
        return ResponseEntity.ok(dishMapper.toDto(dishService.getOne(id)));
    }

    @GetMapping()
    ResponseEntity<?> getAll(@PageableDefault Pageable pageable) {
        List<DishDto> dishDtoList = dishService.getAll(pageable).stream()
                .map(dishMapper::toDto).collect(Collectors.toList());
        boolean tmp = dishService.getAll(pageable).hasNext();
        ResponseEntity.BodyBuilder bodyBuilder = tmp ? ResponseEntity.status(HttpStatus.PARTIAL_CONTENT) : ResponseEntity.status(HttpStatus.OK);
        return bodyBuilder.body(new ResponsePage(dishDtoList, tmp));
    }

    @PostMapping()
    ResponseEntity<DishDto> create(@RequestBody @Valid DishDto dishDto) {
        ResponseEntity.status(HttpStatus.OK);
        return ResponseEntity.ok(dishMapper.toDto(dishService.create(dishDto)));

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
}
