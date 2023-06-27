package com.example.multidb.customer.controller;

import com.example.multidb.customer.entity.Customer;
import com.example.multidb.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customer/")
public class CustomerController {
    @Autowired
    private CustomerRepository repository;

    @PostMapping("create")
    public void createCustomer(@RequestBody Customer customer){
        repository.save(customer);
    }


}
