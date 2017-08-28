package com.ak.learning.um.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@Import({
        UmContextConfig.class,
        UmPersistenceJpaConfig.class,
        UmServiceConfig.class,
        UmWebConfig.class
})


/**
 * SpringBootServletInitializer is an extension of WebApplicationInitializer. It is needed to run
 * a SpringApplication from a WAR deployment. The implementing classes are supposed to provided the
 * source configuration class by extending configure() method. The configuration source class should
 * be annotated with @SpringBootApplication or its variant.
 */
public class UmApp extends SpringBootServletInitializer {

    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }


    @Bean // This used to register a secondary servlet within SpringBoot
    public ServletRegistrationBean dispatcherServletRegistration() {
        final ServletRegistrationBean registrationBean = new ServletRegistrationBean(dispatcherServlet(), "/api/*");

        // add the configuration that you find in web.xml
        final Map<String, String> params = new HashMap<>();
        params.put("ContextClass","org.springframework.web.context.support.AnnotationConfigWebApplicationContext");
        params.put("ContextConfigLocation","org.spring.sec2.spring"); // dummy package
        params.put("dispatchOptionsRequest","true");

        registrationBean.setInitParameters(params);
        registrationBean.setLoadOnStartup(1);

        return registrationBean;
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(UmApp.class);
    }


    public static void main(final String... args) {
        SpringApplication.run(UmApp.class, args);
    }
}
