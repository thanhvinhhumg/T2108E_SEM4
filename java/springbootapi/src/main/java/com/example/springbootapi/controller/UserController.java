package com.example.springbootapi.controller;

import com.example.springbootapi.entity.User;
import com.example.springbootapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/createOrUpdate")
    public String createOrUpdateUser(@RequestBody User user){
        try {
            return userService.createOrUpdateUser(user);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            return "error";
        }
    }

    @GetMapping("/getAllUser")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("/get-detail/{id}")
    public User getDetailUser(@PathVariable Long id){
        return userService.findById(id);
    }
}
