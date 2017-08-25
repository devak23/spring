package com.ak.learning.springjsonread.service;

import com.ak.learning.springjsonread.domain.Address;
import com.ak.learning.springjsonread.domain.Company;
import com.ak.learning.springjsonread.domain.Geo;
import com.ak.learning.springjsonread.domain.User;

import java.util.List;

public interface IUserService {
    Iterable<User> getAllUsers();

    Iterable<User> saveAllUsers(List<User> users);

    User getUserById(long id);

    Address getUserAddress(long id);

    Geo getUserGeo(long id);

    Company getUserCompany(long id);
}
