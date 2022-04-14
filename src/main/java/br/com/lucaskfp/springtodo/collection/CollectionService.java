package br.com.lucaskfp.springtodo.collection;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class CollectionService {

    private final CollectionRepository collectionRepository;

    public CollectionEntity getCollection(Integer id) {

        return collectionRepository.findById(id).get();
    }

    public List<CollectionEntity> getCollections() {

        return collectionRepository.findAll();
    }

    public CollectionEntity saveCollection(CollectionEntity collection) {

        return collectionRepository.save(collection);
    }

}
