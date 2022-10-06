package org.itmo.highload.controller;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.dto.foodstuff.FoodstuffDto;
import org.itmo.highload.dto.foodstuff.FoodstuffMapper;
import org.itmo.highload.model.Foodstuff;
import org.itmo.highload.service.FoodstuffService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class FoodstuffController {
    private final FoodstuffService foodstuffService;
    private final FoodstuffMapper foodstuffMapper;


    @GetMapping(value = "/foodstuff/{id}", produces = "application/json")
    public ResponseEntity<FoodstuffDto> getOne(@PathVariable UUID id) {
        return ResponseEntity.ok(foodstuffMapper.toDto(foodstuffService.getOne(id)));
    }

    @GetMapping("/foodstuff/sort-calories")
    public ResponseEntity<Page<FoodstuffDto>> getAllSorted(){
        //fixme : page in url, sort in url
        return ResponseEntity.status(HttpStatus.OK).body(
                foodstuffService.getAll(PageRequest.of(0, 5, Sort.Direction.ASC,"calories"))
                        .map(foodstuffMapper::toDto));
    }

    @GetMapping("/foodstuff")
    public ResponseEntity<Page<FoodstuffDto>> getAll(@PageableDefault Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(
                foodstuffService.getAll(pageable).map(foodstuffMapper::toDto));
    }

    @PostMapping("/foodstuff")
    public ResponseEntity<FoodstuffDto> create(@RequestBody @Valid FoodstuffDto foodstuffDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(foodstuffMapper.toDto(foodstuffService.create(foodstuffMapper.toModel(foodstuffDto))));
    }

    @DeleteMapping("/foodstuff/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        foodstuffService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/foodstuff/{id}")
    public ResponseEntity<Foodstuff> update(@PathVariable UUID id, @RequestBody FoodstuffDto foodstuffDto) {
        return ResponseEntity.status(HttpStatus.OK).body(
                foodstuffService.update(id, foodstuffMapper.toModel(foodstuffDto)));
    }

}
