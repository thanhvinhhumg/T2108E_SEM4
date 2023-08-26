package com.example.springmvc.controller;

import com.example.springmvc.dto.UserDTO;
import com.example.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String getAllUser(Model model) {
        model.addAttribute("users", userService.getAllUser());
        return "user/list-user";
    }

    @GetMapping("/new")
    public String getFormCreateOrUpdate(Model model){
        UserDTO userDTO = new UserDTO();
        model.addAttribute("user", userDTO);
        return "user/createOrUpdateUser";
    }
    @GetMapping("/edit/{id}")
    public String getFormEdit(Model model, @PathVariable Integer id){
        UserDTO userDTO = userService.getUserById(id);
        model.addAttribute("user", userDTO);
        return "user/createOrUpdateUser";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute(name = "user") UserDTO userDTO) {
        if (userDTO.getId() != null) {
            userService.updateUser(userDTO);
        } else {
            userService.createUser(userDTO);
        }
        return "redirect:/user/list";
    }


}
