package com.example.multidb.customer.repository;

import com.example.multidb.customer.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone,Long> {
}
