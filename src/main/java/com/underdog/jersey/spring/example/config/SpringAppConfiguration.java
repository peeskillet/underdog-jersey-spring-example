
package com.underdog.jersey.spring.example.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.underdog.jersey.spring.example.service.HeaderService;
import com.underdog.jersey.spring.example.service.UnderdogHeaderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 *
 * @author PaulSamsotha
 */
@Component
@Configuration
@ComponentScan(basePackages = {
    "com.underdog.jersey.spring.example.service",
    "com.underdog.jersey.spring.example.resource"
})
public class SpringAppConfiguration {
    
    @Configuration
    //@Profile("production")
    static class HeaderServiceConfiguration {
        
        @Bean
        public HeaderService headerService() {
            return new UnderdogHeaderService();
        }
    }
    
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        return mapper;
    }
    
}
