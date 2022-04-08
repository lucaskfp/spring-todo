package br.com.lucaskfp.springtodo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucaskfp.springtodo.models.Task;
import br.com.lucaskfp.springtodo.repositorys.TaskRepository;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

}
