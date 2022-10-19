package org.itmo.highload.foodstuff.controller;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.foodstuff.controller.dto.FoodstuffDto;
import org.itmo.highload.foodstuff.controller.mapper.FoodstuffMapper;
import org.itmo.highload.foodstuff.model.Foodstuff;
import org.itmo.highload.foodstuff.service.FoodstuffService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RequiredArgsConstructor
@RestController()
@RequestMapping("foodstuffs")
public class FoodstuffController {
    private final FoodstuffService foodstuffService;
    private final FoodstuffMapper foodstuffMapper;


    @GetMapping(value = "/{id}")
    public ResponseEntity<FoodstuffDto> getOne(@PathVariable UUID id) {
        return ResponseEntity.ok(foodstuffMapper.toDto(foodstuffService.getOne(id)));
    }

    @GetMapping()
    public ResponseEntity<Page<FoodstuffDto>> getAll(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(
                foodstuffService.getAll(pageable).map(foodstuffMapper::toDto));
    }

    @PostMapping()
    public ResponseEntity<FoodstuffDto> create(@RequestBody @Valid FoodstuffDto foodstuffDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(foodstuffMapper.toDto(foodstuffService.create(foodstuffDto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        foodstuffService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Foodstuff> update(@PathVariable UUID id, @RequestBody FoodstuffDto foodstuffDto) {
        return ResponseEntity.status(HttpStatus.OK).body(
                foodstuffService.update(id, foodstuffDto));
    }

}
