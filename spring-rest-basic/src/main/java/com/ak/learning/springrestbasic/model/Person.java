package com.ak.learning.springrestbasic.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class Person {
    private Long id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String email;
    private PersonStatusEnum status;

    public Long getId() {
        return id;
    }

    public Person setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Person setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Person setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Person setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Person setEmail(String email) {
        this.email = email;
        return this;
    }

    public PersonStatusEnum getStatus() {
        return status;
    }

    public Person setStatus(PersonStatusEnum status) {
        this.status = status;
        return this;
    }
}
