package com.ak.learning.hellointegrationtest.services;

import com.ak.learning.hellointegrationtest.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HelloService implements IHelloService {

  @Override
  public List<User> getUsers() {
    List<User> users = new ArrayList<>(3);
    users.add(new User("Soham", "Kulkarni"));
    users.add(new User("Manik", "Kulkarni"));
    users.add(new User("Abhay", "Kulkarni"));

    return users;
  }
}
