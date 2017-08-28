package com.ak.learning.springrestbasic.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@ConfigurationProperties(prefix = "myapp-config")
public class MyAppConfig {
  private String name;
  private Float version;
  private String author;
  private Date dateOfCreation;
  private String emailAddress;

  public String getName() {
    return name;
  }

  public MyAppConfig setName(String name) {
    this.name = name;
    return this;
  }

  public Float getVersion() {
    return version;
  }

  public MyAppConfig setVersion(Float version) {
    this.version = version;
    return this;
  }

  public String getAuthor() {
    return author;
  }

  public MyAppConfig setAuthor(String author) {
    this.author = author;
    return this;
  }

  public Date getDateOfCreation() {
    return dateOfCreation;
  }

  public MyAppConfig setDateOfCreation(Date dateOfCreation) {
    this.dateOfCreation = dateOfCreation;
    return this;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public MyAppConfig setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
    return this;
  }

  @Override
  public String toString() {
    return "MyAppConfig {" +
        "name='" + name + '\'' +
        ", version=" + version +
        ", author='" + author + '\'' +
        ", dateOfCreation=" + dateOfCreation +
        ", emailAddress='" + emailAddress + '\'' +
        '}';
  }
}

