package com.example.jpa_api.core;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * User: whydda
 * Date: 2020-01-13
 * Time: 오후 12:39
 */
@Configuration
public class JpaConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
