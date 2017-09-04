package com.ak.learning.blogsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class BlogsApp {

  public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(BlogsApp.class, args);
    System.out.println("..:: DATASOURCE ::.. " + context.getBean("dataSource"));

  }

  @PostConstruct
  void started() {
    TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
  }


//  @Bean
//  CommandLineRunner runner() {
//    return args -> {
//      System.out.println("..:: DATASOURCE ::.. " + dataSource);
//    };
//  };
}
