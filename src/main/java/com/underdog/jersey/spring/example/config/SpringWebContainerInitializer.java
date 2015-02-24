
package com.underdog.jersey.spring.example.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 *
 * @author PaulSamsotha
 */
@Order(1)
public class SpringWebContainerInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        registerContextLoaderListener(servletContext);
        
        // Set the Jersey used property to it won't load a ContextLoaderListener
        servletContext.setInitParameter("contextConfigLocation", "");
    }
    
    private void registerContextLoaderListener(ServletContext servletContext) {
        WebApplicationContext webContext;
        webContext = createWebAplicationContext(SpringAppConfiguration.class);
        servletContext.addListener(new ContextLoaderListener(webContext));
    }
    
    public WebApplicationContext createWebAplicationContext(Class... configClasses) {
        AnnotationConfigWebApplicationContext context;
        context = new AnnotationConfigWebApplicationContext();
        context.register(configClasses);
        return context;
    }
}
