package com.ak.learning.employee.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "EMP")
public class Employee {
    @Id
    @GeneratedValue
    @Column(name = "EMPNO")
    private Long num;

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
    private Department department;

    public Long getNum() {
        return num;
    }

    public Employee setNum(Long num) {
        this.num = num;
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
                "num=" + num +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", hireDate=" + hireDate +
                ", salary=" + salary +
                ", commission=" + commission +
                '}';
    }
}