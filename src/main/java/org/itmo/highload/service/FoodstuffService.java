package org.itmo.highload.service;

import lombok.AllArgsConstructor;
import org.itmo.highload.exception.EntityNotFoudException;
import org.itmo.highload.model.Foodstuff;
import org.itmo.highload.repo.FoodstuffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class FoodstuffService {

    @Autowired
    private final FoodstuffRepo foodstuffRepo;

    @Transactional
    public UUID create(Foodstuff foodstuff) {
        foodstuff.setId(UUID.randomUUID());
        return foodstuffRepo.save(foodstuff).getId();
    }

    @Transactional
    public void delete(Foodstuff foodstuff) {
        foodstuffRepo.deleteById(foodstuff.getId());
    }

    public Foodstuff getOne(UUID id) {
        return foodstuffRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoudException(Foodstuff.class, id));
    }

    public Iterable<Foodstuff> getAll(){
        return foodstuffRepo.findAll();
    }

    public Foodstuff update(UUID id, Foodstuff foodstuff) {
        Foodstuff tmpFoodstuff = getOne(id);
       // BeanUtils.copyProperties();
        return null;
    }
}
