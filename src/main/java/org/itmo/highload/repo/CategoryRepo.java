package org.itmo.highload.repo;

import org.itmo.highload.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryRepo extends CrudRepository<Category, UUID> {
}
