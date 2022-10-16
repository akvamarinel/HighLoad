package org.itmo.highload.foodstuff.controller.mapper;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.foodstuff.controller.dto.FoodstuffDto;
import org.itmo.highload.foodstuff.model.Foodstuff;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class FoodstuffMapper {

    public FoodstuffDto toDto(Foodstuff foodstuff) {
        FoodstuffDto foodstuffDto = new FoodstuffDto();
        foodstuffDto.setId(foodstuff.getId());
        foodstuffDto.setName(foodstuff.getName());
        foodstuffDto.setCalories(foodstuff.getCalories());
        return foodstuffDto;
    }

    public Foodstuff toModel(FoodstuffDto foodstuffDto) {
        Foodstuff foodstuff = new Foodstuff();
        foodstuff.setId(UUID.randomUUID());
        foodstuff.setName(foodstuffDto.getName());
        foodstuff.setCalories(foodstuffDto.getCalories());
        return foodstuff;
    }
}
