package com.ak.learning.employee.v1.repositories;


import com.ak.learning.employee.v1.models.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> findByName(String name);

    Employee findById(long id);
}
