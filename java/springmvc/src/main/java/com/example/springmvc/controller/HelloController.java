package com.example.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello/")
public class HelloController {

    @GetMapping("T2801E")
    public String hello(Model model){
        model.addAttribute("name", "FPT Aptech");
        return "index";
    }
}
