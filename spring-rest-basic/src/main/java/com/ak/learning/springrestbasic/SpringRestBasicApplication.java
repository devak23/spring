package com.ak.learning.springrestbasic;

import com.ak.learning.springrestbasic.model.MyAppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties // so we can read properties
public class SpringRestBasicApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringRestBasicApplication.class, args);
    MyAppConfig config = (MyAppConfig) ctx.getBean("myAppConfig");
    System.out.println("config: " + config);

	}
}
