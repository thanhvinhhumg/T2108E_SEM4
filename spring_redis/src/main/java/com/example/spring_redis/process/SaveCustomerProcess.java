package com.example.spring_redis.process;

import com.example.spring_redis.entity.Customer;
import com.example.spring_redis.service.CustomerService;
import com.example.spring_redis.service.RedisCacheService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SaveCustomerProcess implements Runnable{
    private RedisCacheService redisCacheService;
    private CustomerService customerService;
    public SaveCustomerProcess (RedisCacheService redisCacheService, CustomerService customerService) {
        this.customerService = customerService;
        this.redisCacheService = redisCacheService;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("start process save Customer");
                if (redisCacheService.checkExistsKey("QUEUE:CUSTOMER")) {
                    String data = (String)redisCacheService.rPop("QUEUE:CUSTOMER");
                    if (data != null && !data.isEmpty()) {
                        Customer customer = new ObjectMapper().readValue(data, Customer.class);
                        customerService.saveCustomer(customer);
                    }
                }
                System.out.println("end process save Customer");
                Thread.sleep(10000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
