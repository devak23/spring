package com.ak.learning.employee.services.v1;

import com.ak.learning.employee.models.v1.Employee;

import java.util.Collection;
import java.util.List;

public interface EmployeeService {
    Collection<Employee> findAll();

    Employee findById(long employeeId);

    List<Employee> getEmployeesByName(String name);
}
