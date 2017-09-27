package com.sh.learning.resthello.v1.repositories;

import com.sh.learning.resthello.v1.models.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IEmployeeRepository extends CrudRepository<Employee, Long> {
  List<Employee> findAll();

  Employee findById(long id);

  List<Employee> findByJob(String job);
}
