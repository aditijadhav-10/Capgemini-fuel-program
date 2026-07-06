package com.example.Spring6.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public Mo modelMapper(){
        return new ModelMapper();

    }
}
