package org.itmo.highload.userorder.repo;

import org.itmo.highload.userorder.model.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserOrderRepo extends JpaRepository<UserOrder, UUID> {
}
