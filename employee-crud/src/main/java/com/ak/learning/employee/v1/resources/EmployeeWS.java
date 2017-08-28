package com.ak.learning.employee.v1.resources;

import com.ak.learning.employee.v1.models.dto.EmployeeDTO;
import com.ak.learning.employee.v1.models.json.Employee;
import com.ak.learning.employee.v1.models.json.HateoasListModel;
import com.ak.learning.employee.v1.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;


@RestController
@RequestMapping("/rest/v1/employees")
public class EmployeeWS {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<Employee> getEmployees() {
        Collection<EmployeeDTO> employees = employeeService.findAll();
        Employee eJson = new Employee(employees);
        return new ResponseEntity<>(eJson, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable("id") long employeeId) {
        EmployeeDTO employee = employeeService.findById(employeeId);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @RequestMapping(value = "/name={name}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<EmployeeDTO>> getEmployeesByName(@PathVariable("name") String name) {
        List<EmployeeDTO> employees = employeeService.getEmployeesByName(name);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
