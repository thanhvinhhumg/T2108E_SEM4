package com.example.springmvc.service.impl;

import com.example.springmvc.dao.UserDAO;
import com.example.springmvc.dto.UserDTO;
import com.example.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public List<UserDTO> getAllUser() {
        return userDAO.getAllUser();
    }

    @Override
    public void createUser(UserDTO userDTO) {
        userDAO.createUser(userDTO);
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        userDAO.updateUser(userDTO);
    }

    @Override
    public UserDTO getUserById(Integer id) {
        return userDAO.getUserById(id);
    }
}
