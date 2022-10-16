package org.itmo.highload.category.controller.mapper;


import org.itmo.highload.category.controller.dto.CategoryDto;
import org.itmo.highload.category.model.Category;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
public class CategoryMapper {

    public CategoryDto toDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        return categoryDto;
    }

    public Category toModel(CategoryDto categoryDto) {
        Category category = new Category();
        category.setId(UUID.randomUUID());
        category.setName(categoryDto.getName());
        return category;
    }
}
