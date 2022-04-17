package br.com.lucaskfp.springtodo.collection;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectionRepository extends JpaRepository<CollectionEntity, Integer> {

    public List<CollectionEntity> findByUserId(Integer id);

    public Optional<CollectionEntity> findByIdAndUserId(Integer id, Integer userId);

}
