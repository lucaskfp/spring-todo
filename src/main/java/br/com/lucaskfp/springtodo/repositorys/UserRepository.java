package br.com.lucaskfp.springtodo.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lucaskfp.springtodo.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByEmailEquals(String email);

}
