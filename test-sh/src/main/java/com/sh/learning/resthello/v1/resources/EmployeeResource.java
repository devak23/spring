package com.sh.learning.resthello.v1.resources;

import com.sh.learning.resthello.v1.models.Employee;
import com.sh.learning.resthello.v1.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeResource {

  @Autowired
  private IEmployeeService employeeService;

  @GetMapping
  public List<Employee> getEmployees() {
    return employeeService.getEmployees();
  }

  @RequestMapping("/{id}")
  public Employee getEmployeeById(@PathVariable("id") long id) {
    return employeeService.getEmployeeById(id);
  }

  @RequestMapping("/job={job}")
  public List<Employee> getEmmployeesByJob(@PathVariable("job") String job) {
    return employeeService.getEmployeesByJob(job);
  }
}
