package com.ak.learning.employee.v1.repositories;


import com.ak.learning.employee.v1.models.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeRepository {
    List<EmployeeDTO> findByName(String name);

    EmployeeDTO findById(long id);
}
