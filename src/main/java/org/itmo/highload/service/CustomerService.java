package org.itmo.highload.service;

import org.itmo.highload.dto.CustomerDto;
import org.itmo.highload.model.Customer;
import org.itmo.highload.repo.CustomerRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    ModelMapper modelMapper = new ModelMapper();
    @Autowired
    CustomerRepo customerRepo;

    public void createCustomer(CustomerDto customerDto){
        Customer customer = modelMapper.map(customerDto, Customer.class);
        customerRepo.save(customer);
    }




}
