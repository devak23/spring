package com.sh.learning.resthello.v1.resources;

import com.sh.learning.resthello.v1.helper.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloResource {

  @Autowired
  private Author author;

  @Value("${helloresource.app.description}")
  private String desc;
  @Value("${helloresource.app.myauthor}")
  private String myauthor;
  @Value("${helloresource.app.version}")
  private String version;
  @Value("${helloresource.app.dateOfBirth}")
  private String dateOfBirth;

  @GetMapping
  public String greet() {
    return "Hello World!";
  }

//  @RequestMapping("/{myName}")
//  public String greetMe(@PathVariable("myName") String name) {
//    return String.join(" ","Hello", name, desc, author, version, dateOfBirth);
//  }

  @RequestMapping("/{myName}")
  public String greetMe(@PathVariable("myName") String name) {
    System.out.println("author age: " + author.getAge());
    System.out.println("author DOB: " + author.getDob());

    System.out.println("========== printing the application.properties ===============");
    System.out.println("desc: " + desc);
    System.out.println("myAuthor: " + myauthor);
    System.out.println("version: " + version);
    System.out.println("dateOfBirth: " + dateOfBirth);
    System.out.println("==============================================================");

    return String.join(" ", "Hello", name, author.getName(), author.getAddress(), author.getSex(), author.getSibling(), author.getSpouseName());
  }
}
