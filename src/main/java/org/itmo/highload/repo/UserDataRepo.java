package org.itmo.highload.repo;

import org.itmo.highload.model.UserData;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserDataRepo extends CrudRepository<UserData, UUID> {
}
