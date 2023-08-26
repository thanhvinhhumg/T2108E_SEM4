package com.example.spring.soap.annotation;

import com.example.spring.soap.annotation.service.CustomerService;
import com.example.spring.soap.annotation.service.CustomerWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@SpringBootApplication
@Configuration
public class SpringSoapAnnotationApplication {
    @Autowired
    private  CustomerService customerService;

    private static String WS_ENDPOINT = "http://localhost:8081/ws/customer";

    public static void main(String[] args) {
        SpringApplication.run(SpringSoapAnnotationApplication.class, args);

    }

    @Bean
    public void publishEndPoint() {
        Endpoint.publish(WS_ENDPOINT, new CustomerWebService(customerService));
    }

}
