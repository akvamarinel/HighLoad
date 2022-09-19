package org.itmo.highload.repo;

import org.itmo.highload.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepo extends JpaRepository<Order, UUID> {
}
