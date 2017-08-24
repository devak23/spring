package com.ak.learning.springrestbasic.resource;

import com.ak.learning.springrestbasic.model.Task;
import com.ak.learning.springrestbasic.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/rest/tasks")
public class TaskResource {
    @Autowired
    private ITaskService taskService;

    @GetMapping
    public ResponseEntity<Collection<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Task> getTaskById(@PathVariable("id") Long id) {
        Task task = taskService.getTaskById(id);
        return new ResponseEntity<Task>(task, HttpStatus.OK);
    }
}
