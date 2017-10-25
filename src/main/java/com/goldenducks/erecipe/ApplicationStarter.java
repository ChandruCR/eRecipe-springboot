package com.goldenducks.erecipe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApplicationStarter {
		public static void main(String[] args) {
			SpringApplication.run(ApplicationStarter.class, args);
		}
}
