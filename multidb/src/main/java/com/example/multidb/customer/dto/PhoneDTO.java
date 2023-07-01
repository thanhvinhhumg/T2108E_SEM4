package com.example.multidb.customer.dto;

import lombok.Data;

@Data
public class PhoneDTO {
    private Long id;
    private String phoneNumber;
    private CustomerDTO customer;
}
