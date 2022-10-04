package org.itmo.highload.service;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.dto.customer.CustomerDto;
import org.itmo.highload.model.Customer;
import org.itmo.highload.repo.CustomerRepo;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomerService {
    CustomerRepo customerRepo;


}
