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

  private String firstname;
  private String lastname;
  private String emailAddress;

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

  public String getEmailAddress() {
    return emailAddress;
  }

  public Author setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
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
    return emailAddress != null ? emailAddress.equals(author.emailAddress) : author.emailAddress == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + firstname.hashCode();
    result = 31 * result + lastname.hashCode();
    result = 31 * result + (emailAddress != null ? emailAddress.hashCode() : 0);
    return result;
  }
}
