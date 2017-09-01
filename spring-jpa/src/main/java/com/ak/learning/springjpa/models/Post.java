package com.ak.learning.springjpa.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Post {
  @Id
  @GeneratedValue
  private Long id;

  private String title;

  @Column(columnDefinition = "TEXT") // so that large amount of text can be stored
  private String teaser;

  @Column(columnDefinition = "TIMESTAMP")
  private Date postedOn;

  @ManyToOne (fetch = FetchType.EAGER)
  private Author author;


  // private constructor needed by JPA
  private Post() {}

  public Post(String title) {
    this.title = title;
  }

  public Long getId() {
    return id;
  }

  public Post setId(Long id) {
    this.id = id;
    return this;
  }

  public String getTitle() {
    return title;
  }

  public Post setTitle(String title) {
    this.title = title;
    return this;
  }

  public String getTeaser() {
    return teaser;
  }

  public Post setTeaser(String teaser) {
    this.teaser = teaser;
    return this;
  }

  public Date getPostedOn() {
    return postedOn;
  }

  public Post setPostedOn(Date postedOn) {
    this.postedOn = postedOn;
    return this;
  }

  public Author getAuthor() {
    return author;
  }

  public Post setAuthor(Author author) {
    this.author = author;
    return this;
  }
}
