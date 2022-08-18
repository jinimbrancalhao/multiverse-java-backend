package com.pluralsight.pluralsightdemo;

import com.pluralsight.pluralsightdemo.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class PluralsightDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PluralsightDemoApplication.class, args);
	}

}
