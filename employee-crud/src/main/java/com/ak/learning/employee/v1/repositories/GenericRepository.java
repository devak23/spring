package com.ak.learning.employee.v1.repositories;


import com.ak.learning.employee.v1.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericRepository extends JpaRepository<Employee, Long> {
}
