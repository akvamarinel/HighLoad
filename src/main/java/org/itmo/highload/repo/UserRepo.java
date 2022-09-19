package org.itmo.highload.repo;

import org.itmo.highload.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepo extends CrudRepository<User, UUID> {
}
