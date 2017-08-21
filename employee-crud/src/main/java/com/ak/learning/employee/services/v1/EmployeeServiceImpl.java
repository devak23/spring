package com.ak.learning.employee.services.v1;


import com.ak.learning.employee.models.v1.Employee;
import com.ak.learning.employee.repositories.v1.EmployeeRepository;
import com.ak.learning.employee.repositories.v1.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private GenericRepository genericRepository;

    @Override
    public Collection<Employee> findAll() {
        return genericRepository.findAll();
    }

    @Override
    public Employee findById(long employeeId) {
        return employeeRepository.findById(employeeId);
    }

    @Override
    public List<Employee> getEmployeesByName(String name) {
        return employeeRepository.findByName(name);
    }

}
