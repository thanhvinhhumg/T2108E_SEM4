package com.example.springbean.bean;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private Integer age;
    private String address;
}
