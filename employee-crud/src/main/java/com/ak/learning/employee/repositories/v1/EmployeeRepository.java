package com.ak.learning.employee.repositories.v1;

import com.ak.learning.employee.models.v1.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> findByName(String name);

    Employee findById(long id);
}
