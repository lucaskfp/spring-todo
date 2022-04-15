package br.com.lucaskfp.springtodo.task;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskEntity getTask(Integer id) {
        return this.taskRepository.findById(id).get();
    }

    public List<TaskEntity> getTasks() {
        return this.taskRepository.findAll();
    }

    public TaskEntity saveTask(TaskEntity task) {
        return this.taskRepository.save(task);
    }

}
