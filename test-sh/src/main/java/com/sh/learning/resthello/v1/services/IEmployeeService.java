package com.sh.learning.resthello.v1.services;

import com.sh.learning.resthello.v1.models.Employee;

import java.util.List;

public interface IEmployeeService {
  List<Employee> getEmployees();

  Employee getEmployeeById(long id);

  List<Employee> getEmployeesByJob(String job);
}
