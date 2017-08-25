package com.ak.learning.springjsonread.resource;

import com.ak.learning.springjsonread.domain.User;
import com.ak.learning.springjsonread.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Invoke with http://localhost:8080/rest/v1/users

@RestController
@RequestMapping("/rest/v1/users")
public class UserResource {
    @Autowired
    private IUserService userService;

    @GetMapping
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping("/{id}")
    public User getUserById(@PathVariable("id") long id) {
        return userService.getUserById(id);
    }

}
