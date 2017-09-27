package com.sh.learning.resthello.v1.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EMP")
public class Employee {
  @Id
  @GeneratedValue
  @Column(name = "EMPNO")
  private Long id;



  private String ename;
  private String job;
  private Date hireDate;
  private Double sal;
  private Double comm;
  private Integer deptno;

  @ManyToOne
  @JoinColumn(name = "MGR")
  private Employee manager;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEname() {
    return ename;
  }

  public Employee setEname(String ename) {
    this.ename = ename;
    return this;
  }

  public String getJob() {
    return job;
  }

  public Employee setJob(String job) {
    this.job = job;
    return this;
  }

  public Date getHireDate() {
    return hireDate;
  }

  public Employee setHireDate(Date hireDate) {
    this.hireDate = hireDate;
    return this;
  }

  public Double getSal() {
    return sal;
  }

  public Employee setSal(Double sal) {
    this.sal = sal;
    return this;
  }

  public Double getComm() {
    return comm;
  }

  public Employee setComm(Double comm) {
    this.comm = comm;
    return this;
  }

  public Integer getDeptno() {
    return deptno;
  }

  public Employee setDeptno(Integer deptno) {
    this.deptno = deptno;
    return this;
  }

  public Employee getManager() {
    return manager;
  }

  public Employee setManager(Employee manager) {
    this.manager = manager;
    return this;
  }
}
