package com.example.multidb.customer.dto;

import lombok.Data;

import java.util.List;

@Data
public class CustomerDTO {
    private Long id;
    private String name;
    private Integer age;
    private String address;
    List<PhoneDTO> phones;
}
