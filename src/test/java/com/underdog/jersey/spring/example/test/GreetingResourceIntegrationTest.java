
package com.underdog.jersey.spring.example.test;

import com.underdog.jersey.spring.example.config.JerseyAppConfiguration;
import com.underdog.jersey.spring.example.config.SpringAppConfiguration;

import javax.ws.rs.core.Application;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author PaulSamsotha
 */
public class GreetingResourceIntegrationTest extends JerseyTest {
    
    @Override
    public Application configure() {
        JerseyAppConfiguration config = new JerseyAppConfiguration();
        config.property("contextConfig", 
                new AnnotationConfigApplicationContext(SpringAppConfiguration.class));
        return config;
    }
    
    @Test
    public void testGetGreeting() {
        String response = target("greeting")
                .queryParam("name", "peeskillet")
                .request().get(String.class);
        System.out.println(response);
        Assert.assertEquals("Bonjour, peeskillet!", response);
    }
}
