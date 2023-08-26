package com.example.springbean.config;

import com.example.springbean.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfig {
    @Bean(name = "user")
    @Scope("prototype")
    public User createUserBean() {
        return new User("User Bean",20,"Hà Nội");
    }
}
