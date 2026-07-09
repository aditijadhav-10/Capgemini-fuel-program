package com.example.Spring_E_Com.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.ModelMap;

@Configuration
public class ModelMapperCofig {
    @Bean
    public ModelMapper modelMapper()
    {
        return new ModelMapper();
    }
}
