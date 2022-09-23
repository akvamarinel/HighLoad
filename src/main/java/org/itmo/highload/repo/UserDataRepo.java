package org.itmo.highload.repo;

import org.itmo.highload.model.UserData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface UserDataRepo extends CrudRepository<UserData, UUID> {

    void findByLoginAndPassword(UserData userData);
}
