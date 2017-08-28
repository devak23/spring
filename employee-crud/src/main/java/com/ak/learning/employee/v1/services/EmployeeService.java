package com.ak.learning.employee.v1.services;


import com.ak.learning.employee.v1.models.dto.EmployeeDTO;

import java.util.Collection;
import java.util.List;

public interface EmployeeService {
    Collection<EmployeeDTO> findAll();

    EmployeeDTO findById(long employeeId);

    List<EmployeeDTO> getEmployeesByName(String name);
}
