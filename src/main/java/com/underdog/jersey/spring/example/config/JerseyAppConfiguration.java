
package com.underdog.jersey.spring.example.config;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author PaulSamsotha
 */
@ApplicationPath("/rest")
public class JerseyAppConfiguration extends ResourceConfig {
    
    public JerseyAppConfiguration() {
         packages("com.underdog.jersey.spring.example");
    }
}
