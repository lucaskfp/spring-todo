package br.com.lucaskfp.springtodo.services.task;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.lucaskfp.springtodo.models.Task;
import br.com.lucaskfp.springtodo.repositorys.TaskRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class TaskService implements ITask {

    private final TaskRepository taskRepository;

    @Override
    public Task getTask(Integer id) {
        return taskRepository.findById(id).get();
    }

    @Override
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

}
