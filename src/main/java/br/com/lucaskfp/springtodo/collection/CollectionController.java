package br.com.lucaskfp.springtodo.collection;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/collections")
@RequiredArgsConstructor
public class CollectionController {

    private final CollectionService collectionService;

    @GetMapping("/{id}")
    public ResponseEntity<CollectionEntity> getCollection(@PathVariable("id") Integer collectionId) {
        return ResponseEntity.ok().body(collectionService.getCollection(collectionId));
    }

    @GetMapping
    public ResponseEntity<List<CollectionEntity>> getCollections() {
        return ResponseEntity.ok().body(collectionService.getCollections());
    }

}
