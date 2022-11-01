package org.itmo.highload.category.controller;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.category.controller.dto.CategoryDto;
import org.itmo.highload.category.controller.mapper.CategoryMapper;
import org.itmo.highload.category.service.CategoryService;
import org.itmo.highload.common.ResponsePage;
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
@RestController()
@RequestMapping("categories")
public class CategoryController {
    private final CategoryMapper categoryMapper;
    private final CategoryService categoryService;

    @PostMapping()
    public ResponseEntity<CategoryDto> create(@RequestBody @Valid CategoryDto categoryDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(categoryMapper.toDto(categoryService.create(categoryMapper.toModel(categoryDto))));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getOne(@PathVariable UUID id) {
        return ResponseEntity.ok(categoryMapper.toDto(categoryService.getOne(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        categoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<ResponsePage> getAll(@PageableDefault Pageable pageable) {
        List<CategoryDto> categoryDtoList = categoryService.getAll(pageable).stream().map(categoryMapper::toDto).collect(Collectors.toList());
        boolean tmp = categoryService.getAll(pageable).hasNext();
        ResponseEntity.BodyBuilder bodyBuilder = tmp ? ResponseEntity.status(HttpStatus.PARTIAL_CONTENT) : ResponseEntity.status(HttpStatus.OK);
        return bodyBuilder.body(new ResponsePage(categoryDtoList, tmp));
    }

    @PostMapping("/{id}")
    public ResponseEntity<CategoryDto> update(@PathVariable UUID id, @RequestBody @Valid CategoryDto categoryDto) {
        return ResponseEntity.ok(categoryMapper.toDto(categoryService.update(id, categoryDto)));
    }
}
