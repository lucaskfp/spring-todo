package br.com.lucaskfp.springtodo.task;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/{id}")
    public ResponseEntity<TaskEntity> getTask(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(taskService.getTask(id));
    }

    @GetMapping
    public ResponseEntity<List<TaskEntity>> getTasks() {
        return ResponseEntity.ok().body(taskService.getTasks());
    }

    @PostMapping
    public ResponseEntity<TaskEntity> saveTask(@RequestBody TaskEntity task) {

        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.saveTask(task));
    }

}
