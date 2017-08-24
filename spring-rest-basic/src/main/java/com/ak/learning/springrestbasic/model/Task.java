package com.ak.learning.springrestbasic.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Task {
    private Long id;
    private String name;
    private String description;
    private String startDate;
    private String endDate;
    private TaskStatusEnum status;
    private Person owner;

    public Long getId() {
        return id;
    }

    public Task setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Task setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Task setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getStartDate() {
        return startDate;
    }

    public Task setStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    public String getEndDate() {
        return endDate;
    }

    public Task setEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    public TaskStatusEnum getStatus() {
        return status;
    }

    public Task setStatus(TaskStatusEnum status) {
        this.status = status;
        return this;
    }

    public Person getOwner() {
        return owner;
    }

    public Task setOwner(Person owner) {
        this.owner = owner;
        return this;
    }
}
