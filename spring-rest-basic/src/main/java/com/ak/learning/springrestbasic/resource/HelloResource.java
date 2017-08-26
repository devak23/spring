package com.ak.learning.springrestbasic.resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/hello")
public class HelloResource {

    @Value("${helloResource.greet.message}")
    private String message;

    @Value("${helloResource.helloWorldMessage}")
    private String helloWorldMessage;

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public ResponseEntity<String> greet(@PathVariable("name") String name) {
        return new ResponseEntity<>(message + name, HttpStatus.OK);
    }

    @RequestMapping("/yaml")
    public String greetMe() {
        return helloWorldMessage;
    }
}
