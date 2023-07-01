package com.example.multidb.customer.service;

import com.example.multidb.customer.dto.PhoneDTO;
import com.example.multidb.customer.entity.Customer;
import com.example.multidb.customer.entity.Phone;
import com.example.multidb.customer.repository.CustomerRepository;
import com.example.multidb.customer.repository.PhoneRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class PhoneService {
    @Autowired
    private PhoneRepository repository;

    @Autowired
    CustomerRepository customerRepository;
    private ModelMapper modelMapper;

    @PostConstruct
    public void createInstance(){
        modelMapper = new ModelMapper();
    }
    public void createPhone(PhoneDTO phoneDTO) {
        Customer customer = customerRepository.findById(phoneDTO.getCustomer().getId()).get();
        if (customer != null) {
            Phone phone = modelMapper.map(phoneDTO, Phone.class);
            phone.setCustomer(customer);
            repository.save(phone);
        }
    }

}
