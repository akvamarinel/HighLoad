package org.itmo.highload.repo;

import org.itmo.highload.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepo extends CrudRepository<User, UUID> {
}
