package br.com.lucaskfp.springtodo.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lucaskfp.springtodo.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

}
