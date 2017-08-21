package com.ak.learning.employee;

import com.ak.learning.employee.repositories.v1.GenericRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.ak.learning")
public class EmployeeCrud {
	public static void main(String[] args) {
		SpringApplication.run(EmployeeCrud.class, args);
	}

	@Bean
	CommandLineRunner runner(GenericRepository rep) {
		return args -> rep.findAll().forEach(System.out::println);
	}
}
