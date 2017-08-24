package com.ak.learning.springrestbasic.service;

import com.ak.learning.springrestbasic.model.Task;
import com.ak.learning.springrestbasic.model.TaskStatusEnum;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService implements ITaskService {
    private List<Task> tasks;

    public TaskService() {
        this.tasks = new ArrayList<>();
        tasks.add(
                new Task()
                        .setId(1L)
                        .setName("Windows Installation")
                        .setDescription("Install Windows for eMAM web tier")
                        .setStatus(TaskStatusEnum.COMPLETED)
        );

        tasks.add(
                new Task()
                        .setId(2L)
                        .setName("Clustering Windows Server")
                        .setDescription("Clustering enabled for eMAM web tier")
                        .setStatus(TaskStatusEnum.IN_PROGRESS)
        );

        tasks.add(
                new Task()
                        .setId(3L)
                        .setName("Testing product")
                        .setDescription("Provide 2/3 active directory users for testing")
                        .setStatus(TaskStatusEnum.NEW)
        );

        tasks.add(
                new Task()
                        .setId(4L)
                        .setName("Email")
                        .setDescription("Provide SMTP credentials for enabling eMAM to send emails")
                        .setStatus(TaskStatusEnum.CANCELED)
        );

    }

    @Override
    public List<Task> getAllTasks() {
        return tasks;
    }

    public Task getTaskById(Long id) {
        if (id != null) {
            for (Task task : tasks) {
                if (task.getId().equals(id)) {
                    return task;
                }
            }
        }

        return new Task().setId(null).setName("Invalid Task").setDescription("Invalid Task");
    }
}
