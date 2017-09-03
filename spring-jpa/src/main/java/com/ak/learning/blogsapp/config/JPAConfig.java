package com.ak.learning.blogsapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.ak.learning.blogsapp.repositories"})
public class JPAConfig {
}
