package com.ak.learning.employee.v1.models.dto;

import javax.persistence.*;

@Entity
@Table(name = "DEPT")
public class DepartmentDTO {
    @Id
    @GeneratedValue
    @Column(name = "DEPTNO")
    private long id;

    @Column(name = "DNAME")
    private String name;

    @Column(name = "LOC")
    private String location;

//    @OneToMany (fetch = FetchType.LAZY)
//    private Collection<EmployeeDTO> employees;

    public long getId() {
        return id;
    }

    public DepartmentDTO setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public DepartmentDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public DepartmentDTO setLocation(String location) {
        this.location = location;
        return this;
    }

//    public Collection<EmployeeDTO> getEmployees() {
//        return employees;
//    }
//
//    public DepartmentDTO setEmployees(Collection<EmployeeDTO> employees) {
//        this.employees = employees;
//        return this;
//    }
}
