package com.sh.learning.resthello.v1.helper;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@ConfigurationProperties(prefix = "helloResource.author")
public class Author {
  private String name;
  private float age;
  private Date dob;
  private String address;
  private String sex;
  private String sibling;
  private String siblingName;
  private String spouseName;

  public String getName() {
    return name;
  }

  public Author setName(String name) {
    this.name = name;
    return this;
  }

  public float getAge() {
    return age;
  }

  public Author setAge(float age) {
    this.age = age;
    return this;
  }

  public Date getDob() {
    return dob;
  }

  public Author setDob(Date dob) {
    this.dob = dob;
    return this;
  }

  public String getAddress() {
    return address;
  }

  public Author setAddress(String address) {
    this.address = address;
    return this;
  }

  public String getSex() {
    return sex;
  }

  public Author setSex(String sex) {
    this.sex = sex;
    return this;
  }

  public String getSibling() {
    return sibling;
  }

  public Author setSibling(String sibling) {
    this.sibling = sibling;
    return this;
  }

  public String getSiblingName() {
    return siblingName;
  }

  public Author setSiblingName(String siblingName) {
    this.siblingName = siblingName;
    return this;
  }

  public String getSpouseName() {
    return spouseName;
  }

  public Author setSpouseName(String spouseName) {
    this.spouseName = spouseName;
    return this;
  }
}
