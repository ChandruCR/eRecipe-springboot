package com.goldenducks.erecipe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.goldenducks.erecipe.controller.ERecipeController;

@SpringBootApplication
@EnableDiscoveryClient
public class ERecipeApplication {
	private static final Logger logger = LoggerFactory.getLogger(ERecipeController.class);
		
	public static void main(String[] args) {
		logger.debug("Starting eRecipe Application");
		SpringApplication.run(ERecipeApplication.class, args);
	}
}
