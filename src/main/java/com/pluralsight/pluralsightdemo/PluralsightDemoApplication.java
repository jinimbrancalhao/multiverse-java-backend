package com.pluralsight.pluralsightdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class PluralsightDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PluralsightDemoApplication.class, args);
	}

}
