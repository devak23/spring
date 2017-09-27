package com.ak.learning.hellointegrationtest.resources;

import com.ak.learning.hellointegrationtest.models.User;
import com.ak.learning.hellointegrationtest.services.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(HelloResource.HELLO_BASE_URI)
public class HelloResource {

  public static final String HELLO_BASE_URI = "/myapp/api/hello";

  private IHelloService helloService;

  @Autowired
  public void setHelloService(IHelloService helloService) {
    this.helloService = helloService;
  }

  @RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public String greet() {
    return "Hello World";
  }

  @RequestMapping(value = "/{name}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public String greet(@PathVariable("name") String name) {
    return "Hello " + name;
  }

  @RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public List<User> getUsers() {
    return helloService.getUsers();
  }
}
