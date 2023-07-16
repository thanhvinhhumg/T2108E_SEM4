package com.example.spring_schedule.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class CommonConfig {
    @Value("${process.enable}")
    public String processEnable;
}
