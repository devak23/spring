package com.ak.learning.employee.v1.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "EMP")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employee {
    @Id
    @GeneratedValue
    @Column(name = "EMPNO")
    private Long id;

    @Column(name = "ENAME")
    private String name;

    @Column(name = "JOB")
    private String job;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MGR")
    private Employee manager;

    @Column(name = "HIREDATE")
    private Date hireDate;

    @Column(name = "SAL")
    private Double salary;

    @Column(name = "COMM")
    private Double commission;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEPTNO")
    @JsonIgnore
    private Department department;

    public Long getId() {
        return id;
    }

    public Employee setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public String getJob() {
        return job;
    }

    public Employee setJob(String job) {
        this.job = job;
        return this;
    }

    public Employee getManager() {
        return manager;
    }

    public Employee setManager(Employee manager) {
        this.manager = manager;
        return this;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public Employee setHireDate(Date hireDate) {
        this.hireDate = hireDate;
        return this;
    }

    public Double getSalary() {
        return salary;
    }

    public Employee setSalary(double salary) {
        this.salary = salary;
        return this;
    }

    public Double getCommission() {
        return commission;
    }

    public Employee setCommission(double commission) {
        this.commission = commission;
        return this;
    }

    public Department getDepartment() {
        return department;
    }

    public Employee setDepartment(Department department) {
        this.department = department;
        return this;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", hireDate=" + hireDate +
                ", salary=" + salary +
                ", commission=" + commission +
                '}';
    }
}