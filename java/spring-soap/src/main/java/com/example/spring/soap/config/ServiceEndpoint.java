package com.example.spring.soap.config;

import com.example.spring.soap.*;
import com.example.spring.soap.entity.CustomerEntity;
import com.example.spring.soap.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ServiceEndpoint {
    private static final String NAMESPACE_URI = "http://www.example.com/spring/soap";
    @Autowired
    private CustomerRepository customerRepository;
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCustomerRequest")
    @ResponsePayload
    public GetCustomerResponse getCustomer(@RequestPayload GetCustomerRequest request) {
        GetCustomerResponse response = new GetCustomerResponse();
        response.convertCustomers(customerRepository.findByName(request.getName()));
        return response;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addCustomerRequest")
    @ResponsePayload
    public AddCustomerResponse addCustomer(@RequestPayload AddCustomerRequest request) {
        AddCustomerResponse response = new AddCustomerResponse();
        try {
            CustomerEntity customer = convert(request.getCustomer());
            customerRepository.save(customer);
            response.setMessage("add customer success");
        } catch (Exception ex) {
            response.setMessage(ex.getMessage());
        }
        return response;
    }
    private CustomerEntity convert(Customer customer) {
        return new CustomerEntity(customer.getName(), customer.getAge(), customer.getAddress());
    }
}
