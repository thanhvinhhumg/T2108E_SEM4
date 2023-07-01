package com.example.multidb.customer.controller;

import com.example.multidb.customer.dto.PhoneDTO;
import com.example.multidb.customer.entity.Phone;
import com.example.multidb.customer.repository.PhoneRepository;
import com.example.multidb.customer.service.PhoneService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("api/v1/phone")
public class PhoneController {

    @Autowired
    private PhoneService phoneService;

    @PostMapping("/create")
    public void createPhone(@RequestBody PhoneDTO phoneDTO){
        phoneService.createPhone(phoneDTO);
    }

}
