package com.ak.learning.springrestbasic.service;

import com.ak.learning.springrestbasic.model.Task;
import com.ak.learning.springrestbasic.model.TaskStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService implements ITaskService {
    @Autowired
    private IPersonService personService;

    private List<Task> tasks;

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

        return new Task().setId(null).setName("Invalid Element").setDescription("Invalid Element").setStatus(TaskStatusEnum.INVALID);
    }

    @Override
    public void initialize() {
        System.out.println("... intializing Tasks");

        this.tasks = new ArrayList<>();
        tasks.add(
                new Task()
                        .setId(1L)
                        .setName("Windows Installation")
                        .setDescription("Install Windows for eMAM web tier")
                        .setOwner(personService.getPersonById(1L))
                        .setStatus(TaskStatusEnum.COMPLETED)
        );

        tasks.add(
                new Task()
                        .setId(2L)
                        .setName("Clustering Windows Server")
                        .setDescription("Clustering enabled for eMAM web tier")
                        .setOwner(personService.getPersonById(1L))
                        .setStatus(TaskStatusEnum.IN_PROGRESS)
        );

        tasks.add(
                new Task()
                        .setId(3L)
                        .setName("Testing product")
                        .setDescription("Provide 2/3 active directory users for testing")
                        .setOwner(personService.getPersonById(2L))
                        .setStatus(TaskStatusEnum.NEW)
        );

        tasks.add(
                new Task()
                        .setId(4L)
                        .setName("Email")
                        .setDescription("Provide SMTP credentials for enabling eMAM to send emails")
                        .setOwner(personService.getPersonById(4L))
                        .setStatus(TaskStatusEnum.CANCELED)
        );
    }
}
