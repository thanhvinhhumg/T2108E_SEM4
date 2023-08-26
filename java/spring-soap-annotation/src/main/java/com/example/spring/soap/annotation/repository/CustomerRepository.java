package com.example.spring.soap.annotation.repository;

import com.example.spring.soap.annotation.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
