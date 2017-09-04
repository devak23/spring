package com.ak.learning.hellointegrationtest.resources;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(HelloResource.HELLO_BASE_URI)
public class HelloResource {

  public static final String HELLO_BASE_URI = "/myapp/api/hello";

  @RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public String hello() {
    return "Hello World";
  }

  @RequestMapping(value = "/{name}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public String greet(@PathVariable("name") String name) {
    return "Hello " + name;
  }
}
