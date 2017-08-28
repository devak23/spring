package com.ak.learning.employee.v1.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "EMP")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EmployeeDTO {
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
    private EmployeeDTO manager;

    @Column(name = "HIREDATE")
    private Date hireDate;

    @Column(name = "SAL")
    private Double salary;

    @Column(name = "COMM")
    private Double commission;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEPTNO")
    @JsonIgnore
    private DepartmentDTO departmentDTO;

    public Long getId() {
        return id;
    }

    public EmployeeDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public EmployeeDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getJob() {
        return job;
    }

    public EmployeeDTO setJob(String job) {
        this.job = job;
        return this;
    }

    public EmployeeDTO getManager() {
        return manager;
    }

    public EmployeeDTO setManager(EmployeeDTO manager) {
        this.manager = manager;
        return this;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public EmployeeDTO setHireDate(Date hireDate) {
        this.hireDate = hireDate;
        return this;
    }

    public Double getSalary() {
        return salary;
    }

    public EmployeeDTO setSalary(double salary) {
        this.salary = salary;
        return this;
    }

    public Double getCommission() {
        return commission;
    }

    public EmployeeDTO setCommission(double commission) {
        this.commission = commission;
        return this;
    }

    public DepartmentDTO getDepartmentDTO() {
        return departmentDTO;
    }

    public EmployeeDTO setDepartmentDTO(DepartmentDTO departmentDTO) {
        this.departmentDTO = departmentDTO;
        return this;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", hireDate=" + hireDate +
                ", salary=" + salary +
                ", commission=" + commission +
                '}';
    }
}