package com.example.springbootapi.service;

import com.example.springbootapi.entity.User;
import com.example.springbootapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String createOrUpdateUser(User user) {
        try {
            userRepository.save(user);
            return "success";
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            return "error";
        }
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        return userRepository.findById(id).get();
    }

}
