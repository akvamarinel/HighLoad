package org.itmo.highload.foodstuff.service;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.exception.EntityNotFoundException;
import org.itmo.highload.foodstuff.model.Foodstuff;
import org.itmo.highload.foodstuff.repo.FoodstuffRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class FoodstuffService {

    private final FoodstuffRepo foodstuffRepo;

    @Transactional
    public Foodstuff create(Foodstuff foodstuff) {
        foodstuff.setId(UUID.randomUUID());
        return foodstuffRepo.save(foodstuff);
    }

    @Transactional
    public void delete(UUID id) {
        foodstuffRepo.deleteById(getOne(id).getId());
    }

    public Foodstuff getOne(UUID id) {
        return foodstuffRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Foodstuff.class, id));
    }

    public Page<Foodstuff> getAll(Pageable pageable) {
        return foodstuffRepo.findAll(pageable);
    }

    public Foodstuff update(UUID id, Foodstuff foodstuff) {
        Foodstuff tmpFoodstuff = getOne(id);
        // todo: do!
        return null;
    }
}
