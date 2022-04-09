package br.com.lucaskfp.springtodo.services.task;

import java.util.List;

import br.com.lucaskfp.springtodo.models.Task;

public interface ITask {
    Task getTask(Integer id);

    List<Task> getTasks();

    Task saveTask(Task task);
}
