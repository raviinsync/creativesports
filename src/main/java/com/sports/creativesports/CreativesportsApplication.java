package com.sports.creativesports;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CreativesportsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreativesportsApplication.class, args);
	}

}
