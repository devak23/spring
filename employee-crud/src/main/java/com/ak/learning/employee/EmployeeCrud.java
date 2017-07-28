package com.ak.learning.employee;

import com.ak.learning.employee.repositories.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeCrud {
	public static void main(String[] args) {
		SpringApplication.run(EmployeeCrud.class, args);
	}

	@Bean
	CommandLineRunner runner (EmployeeRepository er) {
		return args -> er.findAll().forEach(System.out::println);
	}
}
