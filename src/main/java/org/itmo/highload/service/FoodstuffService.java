package org.itmo.highload.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.itmo.highload.exception.EntityNotFoundException;
import org.itmo.highload.model.Foodstuff;
import org.itmo.highload.repo.FoodstuffRepo;
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
    public UUID create(Foodstuff foodstuff) {
        foodstuff.setId(UUID.randomUUID());
        return foodstuffRepo.save(foodstuff).getId();
    }

    @Transactional
    public void delete(UUID id) {
        foodstuffRepo.deleteById(getOne(id).getId());
    }

    public Foodstuff getOne(UUID id) {
        return foodstuffRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Foodstuff.class, id));
    }

    public Page<Foodstuff> getAll(Pageable pageable){
        return foodstuffRepo.findAll(pageable);
    }

    public Foodstuff update(UUID id, Foodstuff foodstuff) {
        Foodstuff tmpFoodstuff = getOne(id);
       // BeanUtils.copyProperties();
        return null;
    }
}
