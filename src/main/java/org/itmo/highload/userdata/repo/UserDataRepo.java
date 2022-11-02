package org.itmo.highload.userdata.repo;

import org.itmo.highload.userdata.model.UserData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface UserDataRepo extends CrudRepository<UserData, UUID> {
    UserData findByLogin(String name);
}
