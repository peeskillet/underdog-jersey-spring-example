
package com.underdog.jersey.spring.example.test;

import com.underdog.jersey.spring.example.config.SpringAppConfiguration;
import com.underdog.jersey.spring.example.service.GreetingService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author PaulSamsotha
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringAppConfiguration.class})
public class GreetingServiceUnitTest {
    
    @Autowired
    private GreetingService greetingService;
    
    @Test
    public void testFrenchGreeting() {
        String greeting = greetingService.getGreeting("peeskillet");
        Assert.assertEquals("Bonjour, peeskillet!", greeting);
    }
}
