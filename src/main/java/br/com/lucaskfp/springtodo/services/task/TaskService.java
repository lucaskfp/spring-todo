package br.com.lucaskfp.springtodo.services.task;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.lucaskfp.springtodo.models.Task;
import br.com.lucaskfp.springtodo.repositorys.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class TaskService implements ITask {

    private final TaskRepository taskRepository;

    @Override
    public Task getTask(Integer id) {
        log.info("Fetching task by id = {}", id);
        return taskRepository.findById(id).get();
    }

    @Override
    public List<Task> getTasks() {
        log.info("Fetching all tasks");
        return taskRepository.findAll();
    }

    @Override
    public Task saveTask(Task task) {
        log.info("Save new task {} to the database", task.getName());
        return taskRepository.save(task);
    }

}
