package com.goldenducks.erecipe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class ApplicationStarter {
		public static void main(String[] args) {
			SpringApplication.run(ApplicationStarter.class, args);
		}
		
		//Below code will enable Cross Origin Requests
	/*	@Bean
	    public WebMvcConfigurer corsConfigurer() {
	        return new WebMvcConfigurerAdapter() {
	            @Override
	            public void addCorsMappings(CorsRegistry registry) {
	                registry.addMapping("/erecipe/*").allowedOrigins("http://localhost:7002");
	                registry.addMapping("/erecipe/*").allowedOrigins("http://localhost:4200");
	            }
	        };
	    }
*/
}
