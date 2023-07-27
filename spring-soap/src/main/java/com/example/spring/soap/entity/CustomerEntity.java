package com.example.spring.soap.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@Data
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    private String address;

    public CustomerEntity() {
    }

    public CustomerEntity(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}
