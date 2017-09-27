package com.ak.learning.hellointegrationtest.models;

public class User {
  private Long id;
  private String firstname;
  private String lastname;
  private String emailId;

  public User(String firstname, String lastname) {
    this.firstname = firstname;
    this.lastname = lastname;
  }

  public Long getId() {
    return id;
  }

  public User setId(Long id) {
    this.id = id;
    return this;
  }

  public String getFirstname() {
    return firstname;
  }

  public User setFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public String getLastname() {
    return lastname;
  }

  public User setLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public String getEmailId() {
    return emailId;
  }

  public User setEmailId(String emailId) {
    this.emailId = emailId;
    return this;
  }
}
