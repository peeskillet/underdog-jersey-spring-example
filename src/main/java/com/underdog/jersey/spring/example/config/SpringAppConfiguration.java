
package com.underdog.jersey.spring.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
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
    
}
