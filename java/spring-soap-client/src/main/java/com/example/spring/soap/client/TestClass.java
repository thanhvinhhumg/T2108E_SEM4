package com.example.spring.soap.client;

import example.com.spring.soap.AddCustomerResponse;
import example.com.spring.soap.CustomerWebService;
import example.com.spring.soap.CustomerWebServiceService;
import example.com.spring.soap.ResponseObject;

public class TestClass {
    public static void main(String[] args) {
        CustomerWebServiceService customerWebServiceService = new CustomerWebServiceService();
        CustomerWebService customerWebService = customerWebServiceService.getCustomerWebServicePort();
        ResponseObject response = customerWebService.addCustomer("Nguyen Van B", 20, "Ha Noi");
        System.out.println("error code "+response.getErrorCode() + ", message: "+response.getMessage());
    }
}
