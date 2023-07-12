package com.example.multidb.customer.controller;

import com.example.multidb.customer.dto.PhoneDTO;
import com.example.multidb.customer.entity.Customer;
import com.example.multidb.customer.entity.Phone;
import com.example.multidb.customer.repository.PhoneRepository;
import com.example.multidb.customer.service.PhoneService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

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
