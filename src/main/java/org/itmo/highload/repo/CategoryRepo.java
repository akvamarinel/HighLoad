package org.itmo.highload.repo;

import org.itmo.highload.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CategoryRepo extends CrudRepository<Category, UUID> {
}
