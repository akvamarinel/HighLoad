package org.itmo.highload.repo;

import org.itmo.highload.model.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserOrderRepo extends JpaRepository<UserOrder, UUID> {
}
