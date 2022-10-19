package org.itmo.highload.foodstuff.service;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.exception.EntityNotFoundException;
import org.itmo.highload.foodstuff.controller.dto.FoodstuffDto;

import org.itmo.highload.foodstuff.controller.mapper.FoodstuffMapper;
import org.itmo.highload.foodstuff.model.Foodstuff;
import org.itmo.highload.foodstuff.repo.FoodstuffRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class FoodstuffService {

    private final FoodstuffRepo foodstuffRepo;
    private final FoodstuffMapper foodstuffMapper;


    public Page<Foodstuff> getAll(Pageable pageable) {
        return foodstuffRepo.findAll(pageable);
    }

    public Foodstuff getOne(UUID id) {
        return foodstuffRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Foodstuff.class, id));
    }
    public Foodstuff create(FoodstuffDto foodstuffDto) {
        Foodstuff foodstuff = foodstuffMapper.toModel(foodstuffDto);
        return foodstuffRepo.save(foodstuff);
    }

    public void delete(UUID id) {
        Foodstuff foodstuff = getOne(id);
        foodstuffRepo.delete(foodstuff);
    }

    public Foodstuff update(UUID id, FoodstuffDto foodstuffDto) {
        Foodstuff oldFoodstuff = getOne(id);
        Foodstuff foodstuff = foodstuffMapper.toModel(foodstuffDto);
        BeanUtils.copyProperties(foodstuff, oldFoodstuff, "id");
        return foodstuffRepo.save(oldFoodstuff);

    }
}
