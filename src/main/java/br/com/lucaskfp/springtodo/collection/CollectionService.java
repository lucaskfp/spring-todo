package br.com.lucaskfp.springtodo.collection;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.lucaskfp.springtodo.common.errors.NotFoundException;
import br.com.lucaskfp.springtodo.user.UserEntity;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CollectionService {

    private final CollectionRepository collectionRepository;

    public CollectionEntity getCollection(Integer id) {

        return this.collectionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("A coleção não existe."));
    }

    public List<CollectionEntity> getCollections() {

        return this.collectionRepository.findAll();
    }

    public CollectionEntity saveCollection(CollectionEntity collection, UserEntity user) {

        collection.setUser(user);

        return this.collectionRepository.save(collection);
    }

}
