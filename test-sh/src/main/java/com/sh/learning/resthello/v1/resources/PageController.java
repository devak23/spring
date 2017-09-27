package com.sh.learning.resthello.v1.resources;

import com.sh.learning.resthello.v1.helper.App;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageController {

  @Value("${spring.profiles.active}")
  private String environment;

  @Autowired
  private App app;

  @RequestMapping("/")
  public String home() {
    return environment + " " + app.getDescription() + " " + app.getMyauthor();
  }
}
