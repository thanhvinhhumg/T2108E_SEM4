package com.example.springbean.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    private String name;
    private String address;
    private User user;
    public Department (User user){
        this.user = user;
    }
}
