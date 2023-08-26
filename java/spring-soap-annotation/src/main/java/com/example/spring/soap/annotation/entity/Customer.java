package com.example.spring.soap.annotation.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer age;
    private String address;

    public Customer(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}
