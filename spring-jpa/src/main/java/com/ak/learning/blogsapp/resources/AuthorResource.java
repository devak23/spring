package com.ak.learning.blogsapp.resources;

import com.ak.learning.blogsapp.models.Author;
import com.ak.learning.blogsapp.services.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorResource {

  private IAuthorService authorService;

  @Autowired
  public void setAuthorService(IAuthorService authorService) {
    this.authorService = authorService;
  }

  @RequestMapping(value = "", method = RequestMethod.GET) // we can either use @RequestMapping with value="" or use @GetMapping
  public Iterable<Author> getAuthors() {
    return authorService.getAuthors();
  }

  @RequestMapping(value = "/{id}")
  public Author getAuthorById(@PathVariable("id") Long id) {
    return authorService.getAuthorById(id);
  }

  @RequestMapping(value = "/author/name={name}")
  public List<Author> getAuthorByName(@PathVariable("name") String name) {
    return authorService.getAuthorByName(name);
  }

  @RequestMapping(value = "/author/email={emailId}")
  public Author getAuthorByEmailAddress(@PathVariable("emailId") String emailId) {
    return authorService.getAuthorByEmailAddress(emailId);
  }

  @RequestMapping(value = "/", method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.CREATED)
  public void createAuthor(@RequestBody final Author author) {
    authorService.createAuthor(author);
  }
}
