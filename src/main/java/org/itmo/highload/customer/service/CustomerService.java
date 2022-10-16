package org.itmo.highload.customer.service;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.customer.repo.CustomerRepo;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomerService {
    CustomerRepo customerRepo;


}
