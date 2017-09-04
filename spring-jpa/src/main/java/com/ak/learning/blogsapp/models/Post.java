package com.ak.learning.blogsapp.models;

import com.ak.learning.blogsapp.helpers.ISO8601FormatDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

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
  @JsonSerialize(using=ISO8601FormatDateSerializer.class)
  private Date postedOn;

  @ManyToOne (fetch = FetchType.EAGER)
  private Author author;

  @Column(length = 1)
  private int deleted;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Post post = (Post) o;

    if (id != null ? !id.equals(post.id) : post.id != null) return false;
    return title.equals(post.title);
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + title.hashCode();
    return result;
  }
}
