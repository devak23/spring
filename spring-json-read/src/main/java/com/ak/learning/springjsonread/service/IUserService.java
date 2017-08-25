package com.ak.learning.springjsonread.service;

import com.ak.learning.springjsonread.domain.User;

import java.util.List;

public interface IUserService {
    Iterable<User> getAllUsers();

    Iterable<User> saveAllUsers(List<User> users);

    User getUserById(long id);
}
