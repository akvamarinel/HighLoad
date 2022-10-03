package org.itmo.highload.dto.category;

import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import org.itmo.highload.dto.dish.DishDto;
import org.itmo.highload.dto.dish.DishMapper;
import org.itmo.highload.model.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class CategoryMapper {


    public static CategoryDto convertToDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        categoryDto.setDishes(category.getDishes().stream().map(DishMapper::convertToDto).collect(Collectors.toList()));
        return categoryDto;
    }

    public static Category convertToModel(CategoryDto categoryDto){
        return null;
    }
}
