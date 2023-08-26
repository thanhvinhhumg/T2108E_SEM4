package com.example.spring.soap.annotation.service;

import com.example.spring.soap.annotation.entity.Customer;
import com.example.spring.soap.annotation.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
@Configuration
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }
}
