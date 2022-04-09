package br.com.lucaskfp.springtodo.services.collection;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.lucaskfp.springtodo.models.Collection;
import br.com.lucaskfp.springtodo.repositorys.CollectionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CollectionService implements ICollection {

    private final CollectionRepository collectionRepository;

    @Override
    public Collection getCollection(Integer id) {
        log.info("Fetching collection by id = {}", id);
        return collectionRepository.findById(id).get();
    }

    @Override
    public List<Collection> getCollections() {
        log.info("Fetching all collections");
        return collectionRepository.findAll();
    }

    @Override
    public Collection saveCollection(Collection collection) {
        log.info("Save new collection {} to the database", collection.getName());
        return collectionRepository.save(collection);
    }

    // @Autowired
    // CollectionRepository collectionRepository;

    // @GetMapping
    // public List<Collection> getCollections() {
    // return collectionRepository.findAll();
    // }

    // public Collection getCollection(Integer collectionId) {
    // Collection collection =
    // collectionRepository.findById(collectionId).orElse(null);

    // if (collection == null) {
    // throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Coleção não
    // encontrada");
    // }

    // return collection;
    // }
}
