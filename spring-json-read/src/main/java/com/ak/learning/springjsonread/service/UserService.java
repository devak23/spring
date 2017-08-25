package com.ak.learning.springjsonread.service;

import com.ak.learning.springjsonread.domain.User;
import com.ak.learning.springjsonread.respository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Iterable<User> saveAllUsers(List<User> users) {
        return userRepository.save(users);
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findOne(id);
    }
}
