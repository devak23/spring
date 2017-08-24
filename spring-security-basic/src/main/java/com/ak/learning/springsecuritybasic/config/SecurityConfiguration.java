package com.ak.learning.springsecuritybasic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.servlet.Filter;


@EnableWebSecurity // will enable spring security to the application
@Configuration // so that springboot automatically loads this during loading

// WebSecurityConfigurerAdapter is where all spring security related injections happen
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication() // use the in-memory authentication
                .withUser("Abhay").password("secret").roles("ADMIN").and() // create two users
                .withUser("Soham").password("s3cr3t").roles("USER");
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests() // authorize all the http request
                // if you want to authorize just rest requests, then ...
                //.antMatchers("/rest/hello/**").hasRole("ADMIN") // hello is accessible only to admin role
                .anyRequest() // which is any request whatsoever
                //.permitAll() // with permit everything (meaning without any authentication)
                .fullyAuthenticated() // check if the username and password matches
                .and()
                .httpBasic(); // with HTTP basic authentication

        httpSecurity.csrf().disable(); // disable any crosssite scripting.
    }

    @Bean
    public Filter customFilter() {
        return new CustomFilter();
    }
}
