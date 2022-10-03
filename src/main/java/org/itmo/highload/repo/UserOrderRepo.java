package org.itmo.highload.repo;

import org.itmo.highload.model.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserOrderRepo extends JpaRepository<UserOrder, UUID> {
    Optional<UserOrder> findById(UUID id);
}
