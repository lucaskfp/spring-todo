package br.com.lucaskfp.springtodo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucaskfp.springtodo.models.Task;
import br.com.lucaskfp.springtodo.services.task.TaskService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(taskService.getTask(id));
    }

    @GetMapping
    public ResponseEntity<List<Task>> getTasks() {
        return ResponseEntity.ok().body(taskService.getTasks());
    }

    @PostMapping
    public ResponseEntity<Task> saveTask(@RequestBody Task task) {
        return ResponseEntity.created(null).body(taskService.saveTask(task));
    }

}
