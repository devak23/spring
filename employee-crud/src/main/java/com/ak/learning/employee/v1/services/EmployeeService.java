package com.ak.learning.employee.v1.services;


import com.ak.learning.employee.v1.models.Employee;

import java.util.Collection;
import java.util.List;

public interface EmployeeService {
    Collection<Employee> findAll();

    Employee findById(long employeeId);

    List<Employee> getEmployeesByName(String name);
}
