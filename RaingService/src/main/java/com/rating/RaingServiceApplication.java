package com.rating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RaingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RaingServiceApplication.class, args);
	}

}
