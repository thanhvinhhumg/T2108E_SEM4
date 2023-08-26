package com.example.spring.soap.annotation.service;

import com.example.spring.soap.annotation.entity.Customer;
import com.example.spring.soap.annotation.object.ResponseObject;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "CustomerWebService", targetNamespace = "http://com.example/spring/soap")
public class CustomerWebService {
    private final CustomerService customerService;

    public CustomerWebService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @WebMethod(operationName = "addCustomer")
    public ResponseObject addCustomer(
            @WebParam(name = "name") String name,
            @WebParam(name = "age") Integer age,
            @WebParam(name = "address") String address
    ) {
        ResponseObject response = new ResponseObject();
        try {
            Customer customer = new Customer(name, age, address);
            customerService.addCustomer(customer);
            response.setErrorCode(200);
            response.setMessage("success");
        } catch (Exception ex) {
            response.setErrorCode(500);
            response.setMessage(ex.getMessage());
        }
        return  response;
    }
}
