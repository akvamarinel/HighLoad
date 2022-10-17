package org.itmo.highload.category.controller;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.category.controller.dto.CategoryDto;
import org.itmo.highload.category.controller.mapper.CategoryMapper;
import org.itmo.highload.category.service.CategoryService;
import org.itmo.highload.common.ResponsePage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class CategoryController {
    private final CategoryMapper categoryMapper;
    private final CategoryService categoryService;

    @PostMapping("/category")
    public ResponseEntity<CategoryDto> create(@RequestBody @Valid CategoryDto categoryDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(categoryMapper.toDto(categoryService.create(categoryMapper.toModel(categoryDto))));
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<CategoryDto> getOne(@PathVariable UUID id) {
        return ResponseEntity.ok(categoryMapper.toDto(categoryService.getOne(id)));
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        categoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<?> getAll(@PageableDefault Pageable pageable) {
        List<CategoryDto> categoryDtoList = categoryService.getAll(pageable).stream()
                .map(categoryMapper::toDto).collect(Collectors.toList());
        boolean tmp = categoryService.getAll(pageable).hasNext();
        ResponseEntity.BodyBuilder bodyBuilder = tmp ? ResponseEntity.status(HttpStatus.PARTIAL_CONTENT) : ResponseEntity.status(HttpStatus.OK);
        return bodyBuilder.body(new ResponsePage(categoryDtoList, tmp));
    }
}