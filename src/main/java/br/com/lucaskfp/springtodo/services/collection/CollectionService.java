package br.com.lucaskfp.springtodo.services.collection;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.lucaskfp.springtodo.models.Collection;
import br.com.lucaskfp.springtodo.repositorys.CollectionRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class CollectionService implements ICollection {

    private final CollectionRepository collectionRepository;

    @Override
    public Collection getCollection(Integer id) {

        return collectionRepository.findById(id).get();
    }

    @Override
    public List<Collection> getCollections() {

        return collectionRepository.findAll();
    }

    @Override
    public Collection saveCollection(Collection collection) {

        return collectionRepository.save(collection);
    }

}
