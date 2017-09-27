package com.sh.learning.resthello.v1.services;

import com.sh.learning.resthello.v1.models.Employee;
import com.sh.learning.resthello.v1.repositories.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
  @Autowired
  private IEmployeeRepository employeeRepository;


  @Override
  public List<Employee> getEmployees() {
    return employeeRepository.findAll();
  }

  @Override
  public Employee getEmployeeById(long id) {
    return employeeRepository.findById(id);
  }

  @Override
  public List<Employee> getEmployeesByJob(String job) {
    return employeeRepository.findByJob(job);
  }
}
