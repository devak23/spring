package com.ak.learning.blogsapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Author {
  @Id
  @GeneratedValue
  private Long id;

  private String firstname;
  private String lastname;
  @Column(unique = true, length = 50)
  private String email;
  @Column(length = 1)
  private int deleted;

  @OneToMany(mappedBy = "author")
  @JsonIgnore
  private List<Post> posts;

  private Author() {}

  public Author(String firstname, String lastname) {
    this.firstname = firstname;
    this.lastname = lastname;
  }

  public Long getId() {
    return id;
  }

  public Author setId(Long id) {
    this.id = id;
    return this;
  }

  public String getFirstname() {
    return firstname;
  }

  public Author setFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public String getLastname() {
    return lastname;
  }

  public Author setLastname(String lastname) {
    this.lastname = lastname;
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


  public int getDeleted() {
    return deleted;
  }

  public Author setDeleted(int deleted) {
    this.deleted = deleted;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Author author = (Author) o;

    if (id != null ? !id.equals(author.id) : author.id != null) return false;
    if (!firstname.equals(author.firstname)) return false;
    if (!lastname.equals(author.lastname)) return false;
    return email != null ? email.equals(author.email) : author.email == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + firstname.hashCode();
    result = 31 * result + lastname.hashCode();
    result = 31 * result + (email != null ? email.hashCode() : 0);
    return result;
  }
}
