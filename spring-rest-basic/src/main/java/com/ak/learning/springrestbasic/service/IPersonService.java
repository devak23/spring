package com.ak.learning.springrestbasic.service;

import com.ak.learning.springrestbasic.model.Person;

import java.util.List;

public interface IPersonService {
    List<Person> getAllPersons();

    Person getPersonById(Long id);

    void initialize();
}
