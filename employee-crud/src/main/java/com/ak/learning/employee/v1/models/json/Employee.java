package com.ak.learning.employee.v1.models.json;

import com.ak.learning.employee.v1.models.dto.EmployeeDTO;

import java.util.Collection;

public class Employee extends HateoasListModel<EmployeeDTO>{
    public Employee(Collection<EmployeeDTO> employees) {
        super(employees);
    }
}
