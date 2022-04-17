package br.com.lucaskfp.springtodo.task;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.lucaskfp.springtodo.common.errors.NotFoundException;
import br.com.lucaskfp.springtodo.user.UserEntity;
import br.com.lucaskfp.springtodo.user.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskEntity getTask(Integer id, Integer userId) {
        return this.taskRepository.findByIdAndUserId(id, userId)
                .orElseThrow(() -> new NotFoundException("Tarefa não encontrada."));
    }

    public List<TaskEntity> getTasks(Integer userID) {
        return this.taskRepository.findByUserId(userID);
    }

    public TaskEntity saveTask(TaskEntity task, Integer userId) {

        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado."));

        task.setUser(user);

        return this.taskRepository.save(task);
    }

}
