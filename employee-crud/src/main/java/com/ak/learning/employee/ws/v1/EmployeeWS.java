package com.ak.learning.employee.ws.v1;

import com.ak.learning.employee.models.v1.Employee;
import com.ak.learning.employee.services.v1.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("employees")
public class EmployeeWS {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Collection<Employee>> getEmployees() {
        Collection<Employee> employees = employeeService.findAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @RequestMapping(value = "/id={id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") long employeeId) {
        Employee employee = employeeService.findById(employeeId);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @RequestMapping(value = "/name={name}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Employee>> getEmployeesByName(@PathVariable("name") String name) {
        List<Employee> employees = employeeService.getEmployeesByName(name);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}