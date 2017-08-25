package com.ak.learning.springjsonread.respository;

import com.ak.learning.springjsonread.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User, Long> {

}
