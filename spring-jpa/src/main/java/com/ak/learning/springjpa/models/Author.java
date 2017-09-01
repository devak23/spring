package com.ak.learning.springjpa.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Author {
  @Id
  @GeneratedValue
  private Long id;

  private String firstName;
  private String lastName;

  @OneToMany(mappedBy = "author")
  @JsonIgnore
  private List<Post> posts;

  private Author() {}

  public Author(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public Long getId() {
    return id;
  }

  public Author setId(Long id) {
    this.id = id;
    return this;
  }

  public String getFirstName() {
    return firstName;
  }

  public Author setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public Author setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public List<Post> getPosts() {
    return posts;
  }

  public Author setPosts(List<Post> posts) {
    this.posts = posts;
    return this;
  }
}
