package com.ak.learning.employee.repositories.v1;

import com.ak.learning.employee.models.v1.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GenericRepository extends JpaRepository<Employee, Long> {
}
