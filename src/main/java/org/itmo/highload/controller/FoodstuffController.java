package org.itmo.highload.controller;

import lombok.AllArgsConstructor;
import org.itmo.highload.model.Foodstuff;
import org.itmo.highload.service.FoodstuffService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@RestController("foodstuff")
public class FoodstuffController {
    @Autowired
    FoodstuffService foodstuffService;

    ModelMapper modelMapper = new ModelMapper();

    @GetMapping(value = "/foodstuff/{id}", produces = "application/json")
    public ResponseEntity<Foodstuff> getOne(@PathVariable UUID id) {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/foodstuff")
    public ResponseEntity<List<Foodstuff>> getAll(){
        return ResponseEntity.ok(null);
    }

    @PostMapping("/recipes")
    public ResponseEntity<Foodstuff> create(@PathVariable Foodstuff foodstuff) {
        return ResponseEntity.ok(null);
    }

    public ResponseEntity<Foodstuff> delete(@PathVariable Foodstuff foodstuff) {
        return ResponseEntity.ok(null);
    }


}
