package org.itmo.highload.customer.repo;

import org.itmo.highload.customer.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepo extends CrudRepository<Customer, UUID> {
    Customer getCustomerByUserDataId(UUID id);
}
