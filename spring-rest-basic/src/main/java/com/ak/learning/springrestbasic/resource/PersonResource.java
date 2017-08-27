package com.ak.learning.springrestbasic.resource;

import com.ak.learning.springrestbasic.model.Person;
import com.ak.learning.springrestbasic.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/rest/v1/persons")
public class PersonResource {
    private IPersonService personService;

    // this is called setter injection
    @Autowired
    public void setPersonService(IPersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public ResponseEntity<Collection<Person>> getAllPersons() {
        List<Person> persons = personService.getAllPersons();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @RequestMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") Long id) {
        Person person = personService.getPersonById(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }
}
