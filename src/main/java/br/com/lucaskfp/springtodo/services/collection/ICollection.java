package br.com.lucaskfp.springtodo.services.collection;

import java.util.List;

import br.com.lucaskfp.springtodo.models.Collection;

public interface ICollection {

    Collection getCollection(Integer id);

    List<Collection> getCollections();

    Collection saveCollection(Collection collection);
}
