package com.ak.learning.springjsonread;

import com.ak.learning.springjsonread.domain.User;
import com.ak.learning.springjsonread.service.IUserService;
import com.ak.learning.springjsonread.service.UserService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class SpringJsonReadApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJsonReadApplication.class, args);
	}

	// Enable this if you want to load the JSON data from the file into the database
	// since the db file is present in the /resources/db, I've commented this
//	@Bean
//	CommandLineRunner runner(IUserService userService) {
//		return args -> {
//			// read json and write to db
//			ObjectMapper mapper = new ObjectMapper();
//			TypeReference<List<User>> typeReference = new TypeReference<List<User>>() {};
//			InputStream is = TypeReference.class.getResourceAsStream("/json/users.json");
//			try {
//				List<User> users = mapper.readValue(is, typeReference);
//				userService.saveAllUsers(users);
//				System.out.println("..::: Users saved:::..");
//			} catch (IOException ioe) {
//				System.err.println("Unable to save users: " + ioe.getMessage());
//			}
//		};
//	}
}
