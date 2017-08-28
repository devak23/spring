package com.ak.learning.employee.v1.services;


import com.ak.learning.employee.v1.models.dto.EmployeeDTO;
import com.ak.learning.employee.v1.repositories.EmployeeRepository;
import com.ak.learning.employee.v1.repositories.GenericRepository;
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
    public Collection<EmployeeDTO> findAll() {
        return genericRepository.findAll();
    }

    @Override
    public EmployeeDTO findById(long employeeId) {
        return employeeRepository.findById(employeeId);
    }

    @Override
    public List<EmployeeDTO> getEmployeesByName(String name) {
        return employeeRepository.findByName(name);
    }

}
