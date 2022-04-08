package br.com.lucaskfp.springtodo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucaskfp.springtodo.models.Collection;
import br.com.lucaskfp.springtodo.services.CollectionService;

@RestController
@RequestMapping("/collections")
public class CollectionController {

    @Autowired
    CollectionService collectionService;

    @GetMapping
    public List<Collection> getCollections() {
        return collectionService.getCollections();
    }

    @GetMapping("/{id}")
    public Collection getCollection(@PathVariable("id") Integer collectionId) {
        return collectionService.getCollection(collectionId);
    }
}
