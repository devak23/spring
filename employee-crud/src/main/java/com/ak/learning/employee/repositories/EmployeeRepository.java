package com.ak.learning.employee.repositories;

import com.ak.learning.employee.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Collection<Employee> findByName(String name);
}
