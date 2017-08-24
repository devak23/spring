package com.ak.learning.springrestbasic.service;

import com.ak.learning.springrestbasic.model.Person;
import com.ak.learning.springrestbasic.model.PersonStatusEnum;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService implements IPersonService {
    private List<Person> persons;

    @Override
    public List<Person> getAllPersons() {
        return persons;
    }

    @Override
    public Person getPersonById(Long id) {
        if (id != null) {
            for (Person person : persons) {
                if (person.getId().equals(id)) {
                    return person;
                }
            }
        }

        return new Person().setId(null).setFirstName("Invalid Element").setLastName("Invalid Element").setStatus(PersonStatusEnum.INVALID);
    }

    @Override
    public void initialize() {
        System.out.println("... intializing Persons");

        this.persons = new ArrayList<>();
        persons.add(
                new Person().setId(1L).setFirstName("Abhay").setLastName("Kulkarni").setEmail("abhay.kulkarni@icastx.com").setStatus(PersonStatusEnum.ACTIVE)
        );
        persons.add(
                new Person().setId(2L).setFirstName("Vidyadhar").setLastName("Pendurkar").setEmail("vidyadhar.pendurkar@icastx.com").setStatus(PersonStatusEnum.ACTIVE)
        );
        persons.add(
                new Person().setId(3L).setFirstName("DattaTray").setLastName("Kharat").setEmail("dattatray.kharat@icastx.com").setStatus(PersonStatusEnum.ACTIVE)
        );
        persons.add(
                new Person().setId(4L).setFirstName("Komal").setLastName("Haldankar").setEmail("komal.haldankar@icastx.com").setStatus(PersonStatusEnum.ACTIVE)
        );
        persons.add(
                new Person().setId(5L).setFirstName("Pratima").setLastName("Kamat").setEmail("Pratima.Kamat@icastx.com").setStatus(PersonStatusEnum.ACTIVE)
        );
    }

}
