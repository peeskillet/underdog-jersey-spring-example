
package com.underdog.jersey.spring.example.service;

import org.springframework.stereotype.Service;

/**
 *
 * @author PaulSamsotha
 */
@Service
public class FrenchGreetingService implements GreetingService {

    @Override
    public String getGreeting(String name) {
        return "Bonjour, " + name + "!";
    }  
}
