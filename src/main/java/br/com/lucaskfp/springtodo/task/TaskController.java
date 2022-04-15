package br.com.lucaskfp.springtodo.task;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/{id}")
    public TaskEntity getTask(@PathVariable("id") Integer id) {
        return this.taskService.getTask(id);
    }

    @GetMapping
    public List<TaskEntity> getTasks() {
        return this.taskService.getTasks();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskEntity saveTask(@RequestBody TaskEntity task) {

        return this.taskService.saveTask(task);
    }

}
