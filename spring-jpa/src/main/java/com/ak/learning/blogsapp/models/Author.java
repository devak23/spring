package com.ak.learning.blogsapp.models;

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
  private String email;

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

  public String getEmail() {
    return email;
  }

  public Author setEmail(String email) {
    this.email = email;
    return this;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Author author = (Author) o;

    if (id != null ? !id.equals(author.id) : author.id != null) return false;
    if (!firstName.equals(author.firstName)) return false;
    if (!lastName.equals(author.lastName)) return false;
    return email != null ? email.equals(author.email) : author.email == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + firstName.hashCode();
    result = 31 * result + lastName.hashCode();
    result = 31 * result + (email != null ? email.hashCode() : 0);
    return result;
  }
}
