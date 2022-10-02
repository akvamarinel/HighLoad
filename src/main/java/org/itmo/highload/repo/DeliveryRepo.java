package org.itmo.highload.repo;

import org.itmo.highload.model.Delivery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DeliveryRepo extends CrudRepository<Delivery, UUID> {
}
