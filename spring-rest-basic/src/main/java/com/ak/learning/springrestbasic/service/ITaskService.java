package com.ak.learning.springrestbasic.service;

import com.ak.learning.springrestbasic.model.Task;

import java.util.List;

public interface ITaskService {
    List<Task> getAllTasks();

    Task getTaskById(Long id);
}
