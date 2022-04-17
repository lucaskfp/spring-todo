package br.com.lucaskfp.springtodo.task;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {

    public List<TaskEntity> findByUserId(Integer id);

    public Optional<TaskEntity> findByIdAndUserId(Integer id, Integer userId);

}
