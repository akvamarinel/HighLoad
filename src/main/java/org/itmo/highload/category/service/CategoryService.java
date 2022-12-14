package org.itmo.highload.category.service;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.category.controller.dto.CategoryDto;
import org.itmo.highload.exception.EntityNotFoundException;
import org.itmo.highload.category.model.Category;
import org.itmo.highload.category.repo.CategoryRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepo categoryRepo;

    public Category create(Category category) {
        category.setId(UUID.randomUUID());
        return categoryRepo.save(category);
    }

    public void delete(UUID id) {
        categoryRepo.deleteById(getOne(id).getId());
    }

    public Category getOne(UUID id) {
        return categoryRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Category.class, id));
    }

    public Page<Category> getAll(Pageable pageable) {
        return categoryRepo.findAll(pageable);
    }

    public Category update(UUID id, CategoryDto categoryDto) {
        Category category = getOne(id);
        category.setName(categoryDto.getName());
        return categoryRepo.save(category);
    }

}
