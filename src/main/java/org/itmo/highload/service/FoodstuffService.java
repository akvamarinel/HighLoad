package org.itmo.highload.service;

import lombok.AllArgsConstructor;
import org.itmo.highload.model.Foodstuff;
import org.itmo.highload.repo.FoodstuffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class FoodstuffService {

    @Autowired
    private final FoodstuffRepo foodstuffRepo;

    public Foodstuff create(Foodstuff foodstuff) {
        return foodstuffRepo.save(foodstuff);
    }

    public void delete(Foodstuff foodstuff) {
        foodstuffRepo.delete(foodstuff);
    }

    public Optional<Foodstuff> getOne(UUID id) {
        return foodstuffRepo.findById(id);
    }

    public Iterable<Foodstuff> getAll(){
        return foodstuffRepo.findAll();
    }

    public Foodstuff update(UUID id, Foodstuff foodstuff) {
        return null;
    }
}
