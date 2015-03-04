package com.underdog.jersey.spring.example.test;

import com.underdog.jersey.spring.example.resource.GreetingResource;
import com.underdog.jersey.spring.example.service.GreetingService;
import javax.ws.rs.core.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

/**
 *
 * @author PaulSamsotha
 */
@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class GreetingResourceUnitTest {

    @Autowired
    private GreetingResource greetingResource;

    @Test
    public void testGetGreeting() {
        Response response = greetingResource.getGreeting("peeskillet");
        assertEquals("Hello peeskillet", (String) response.getEntity());
    }

    @Configuration
    static class GreetingResourceUnitTestContextConfiguration {

        @Bean
        public GreetingResource greetingResource() {
            return new GreetingResource();
        }

        @Bean
        public GreetingService greetingService() {
            GreetingService greetingService = Mockito.mock(GreetingService.class);
            Mockito.when(greetingService.getGreeting(Mockito.anyString()))
                    .thenAnswer(new Answer<String>() {
                        @Override
                        public String answer(InvocationOnMock invocation) throws Throwable {
                            String name = (String) invocation.getArguments()[0];
                            return "Hello " + name;
                        }
                    });
            return greetingService;
        }
    }
}
