package br.com.lucaskfp.springtodo.task;

import java.util.List;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucaskfp.springtodo.common.View;
import br.com.lucaskfp.springtodo.security.CustomUserDetails;
import br.com.lucaskfp.springtodo.security.LoggedInuser;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
@CrossOrigin("*")
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/{id}")
    @JsonView(View.Base.class)
    public TaskEntity getTask(@PathVariable("id") Integer id, @LoggedInuser CustomUserDetails user) {
        return this.taskService.getTask(id, user.getId());
    }

    @GetMapping
    @JsonView(View.Base.class)
    public List<TaskEntity> getTasks(@LoggedInuser CustomUserDetails user) {
        return this.taskService.getTasks(user.getId());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @JsonView(View.Base.class)
    public TaskEntity saveTask(@Valid @RequestBody TaskEntity task, @LoggedInuser CustomUserDetails user) {

        return this.taskService.saveTask(task, user.getId());
    }

}
