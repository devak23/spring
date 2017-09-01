package com.ak.learning.springjpa.resources;

import com.ak.learning.springjpa.models.Author;
import com.ak.learning.springjpa.services.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class AuthorResource {

  private IAuthorService authorService;

  @Autowired
  public void setAuthorService(IAuthorService authorService) {
    this.authorService = authorService;
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public Iterable<Author> getAuthors() {
    return authorService.getAuthors();
  }

  @RequestMapping(value = "/{id}")
  public Author getAuthorById(@PathVariable("id") Long id) {
    return authorService.getAuthorById(id);
  }
}
