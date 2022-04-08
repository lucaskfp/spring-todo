package br.com.lucaskfp.springtodo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.server.ResponseStatusException;

import br.com.lucaskfp.springtodo.models.Collection;
import br.com.lucaskfp.springtodo.repositorys.CollectionRepository;

@Service
public class CollectionService {

    @Autowired
    CollectionRepository collectionRepository;

    @GetMapping
    public List<Collection> getCollections() {
        return collectionRepository.findAll();
    }

    public Collection getCollection(Integer collectionId) {
        Collection collection = collectionRepository.findById(collectionId).orElse(null);

        if (collection == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Coleção não encontrada");
        }

        return collection;
    }
}
