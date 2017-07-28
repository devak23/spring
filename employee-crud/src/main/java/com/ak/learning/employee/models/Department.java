package com.ak.learning.employee.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "DEPT")
public class Department {
    @Id
    @GeneratedValue
    private long num;

    @Column(name = "DNAME")
    private String name;

    @Column(name = "LOC")
    private String location;

    @OneToMany (fetch = FetchType.LAZY)
    private Collection<Employee> employees;

    public long getNum() {
        return num;
    }

    public Department setNum(long num) {
        this.num = num;
        return this;
    }

    public String getName() {
        return name;
    }

    public Department setName(String name) {
        this.name = name;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public Department setLocation(String location) {
        this.location = location;
        return this;
    }

    public Collection<Employee> getEmployees() {
        return employees;
    }

    public Department setEmployees(Collection<Employee> employees) {
        this.employees = employees;
        return this;
    }
}
