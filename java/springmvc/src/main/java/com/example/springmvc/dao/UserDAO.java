package com.example.springmvc.dao;

import com.example.springmvc.dto.UserDTO;

import java.util.List;

public interface UserDAO {
    List<UserDTO> getAllUser();
    String createUser(UserDTO userDTO);
    void updateUser(UserDTO userDTO);
    UserDTO getUserById(Integer id);
}
