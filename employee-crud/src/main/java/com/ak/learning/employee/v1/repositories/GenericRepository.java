package com.ak.learning.employee.v1.repositories;


import com.ak.learning.employee.v1.models.dto.EmployeeDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericRepository extends JpaRepository<EmployeeDTO, Long> {
}
