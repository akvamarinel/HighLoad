package org.itmo.highload.dish.service;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.exception.EntityNotFoundException;
import org.itmo.highload.dish.model.Dish;
import org.itmo.highload.dish.repo.DishRepo;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class DishService {
    private final DishRepo dishRepo;


    public Dish getOne(UUID id) {
        return dishRepo.findById(id).orElseThrow(() -> new EntityNotFoundException(Dish.class, id));
    }

    public Iterable<Dish> getAll() {
        return dishRepo.findAll();
    }

    public Dish create(Dish dish) {
        return dishRepo.save(dish);
    }


}
