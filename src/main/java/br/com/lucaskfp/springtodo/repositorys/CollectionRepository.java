package br.com.lucaskfp.springtodo.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lucaskfp.springtodo.models.Collection;

@Repository
public interface CollectionRepository extends JpaRepository<Collection, Integer> {

}
