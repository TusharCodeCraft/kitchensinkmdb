package org.jboss.as.quickstarts.kitchensink;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// import org.jboss.as.quickstarts.kitchensink.util.FacesUrlRewriteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import jakarta.faces.webapp.FacesServlet;

@SpringBootApplication
public class KitchensinkmdbApplication {

	public static void main(String[] args) {
		SpringApplication.run(KitchensinkmdbApplication.class, args);
	}

	@Bean
	public Logger logger() {
		return LoggerFactory.getLogger(KitchensinkmdbApplication.class);
	}
	
	@Bean
	public ServletRegistrationBean<FacesServlet> servletRegistrationBean() {
		return new ServletRegistrationBean<>(new FacesServlet(), "*.xhtml");
	}
	
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    
   
}
