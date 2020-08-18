package org.example.config;


import org.example.services.EmailServiceImpl;
import org.example.services.Service;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"org.example.consumer"})
public class DIConfig {
    @Bean
    public Service getServiceImpl() {
     return  new EmailServiceImpl();
    }

}
