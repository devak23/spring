package com.sh.learning.resthello.v1.helper;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@ConfigurationProperties(prefix = "helloresource.app")
public class App {
  private String description;
  private String myauthor;
  private float version;
  private Date dateOfBirth;

  public String getDescription() {
    return description;
  }

  public App setDescription(String description) {
    this.description = description;
    return this;
  }

  public String getMyauthor() {
    return myauthor;
  }

  public App setMyauthor(String myauthor) {
    this.myauthor = myauthor;
    return this;
  }

  public float getVersion() {
    return version;
  }

  public App setVersion(float version) {
    this.version = version;
    return this;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public App setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }
}
