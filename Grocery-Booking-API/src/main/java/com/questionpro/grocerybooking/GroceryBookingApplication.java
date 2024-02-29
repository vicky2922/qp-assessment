package com.questionpro.grocerybooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.questionpro.grocerybooking.repos.UserRepository;

@SpringBootApplication
public class GroceryBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroceryBookingApplication.class, args);
	}

}
