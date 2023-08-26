package com.example.spring_redis;

import com.example.spring_redis.process.SaveCustomerProcess;
import com.example.spring_redis.service.CustomerService;
import com.example.spring_redis.service.RedisCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class SpringRedisApplication {
    @Autowired
    private RedisCacheService redisCacheService;
    @Autowired
    private CustomerService customerService;

    public static void main(String[] args) {
        SpringApplication.run(SpringRedisApplication.class, args);
    }

    @Bean
    public void innitProcess() {
        SaveCustomerProcess saveCustomerProcess = new SaveCustomerProcess(redisCacheService, customerService);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(saveCustomerProcess);
    }
}
