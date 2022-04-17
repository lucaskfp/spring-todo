package br.com.lucaskfp.springtodo.collection;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.lucaskfp.springtodo.common.errors.NotFoundException;
import br.com.lucaskfp.springtodo.user.UserEntity;
import br.com.lucaskfp.springtodo.user.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CollectionService {

    private final CollectionRepository collectionRepository;
    private final UserRepository userRepository;

    public CollectionEntity getCollection(Integer id, Integer userId) {

        return this.collectionRepository.findByIdAndUserId(id, userId)
                .orElseThrow(() -> new NotFoundException("A coleção não existe."));
    }

    public List<CollectionEntity> getCollections(Integer id) {

        return this.collectionRepository.findByUserId(id);
    }

    public CollectionEntity saveCollection(CollectionEntity collection, Integer userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado."));

        collection.setUser(user);

        return this.collectionRepository.save(collection);
    }

}
