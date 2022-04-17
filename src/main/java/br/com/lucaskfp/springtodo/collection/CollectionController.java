package br.com.lucaskfp.springtodo.collection;

import java.util.List;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucaskfp.springtodo.common.View;
import br.com.lucaskfp.springtodo.security.CustomUserDetails;
import br.com.lucaskfp.springtodo.security.LoggedInuser;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/collections")
@RequiredArgsConstructor
public class CollectionController {

    private final CollectionService collectionService;

    @GetMapping("/{id}")
    @JsonView(View.Base.class)
    public CollectionEntity getCollection(@PathVariable("id") Integer collectionId) {
        return this.collectionService.getCollection(collectionId);
    }

    @GetMapping
    @JsonView(View.Base.class)
    public List<CollectionEntity> getCollections() {
        return this.collectionService.getCollections();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @JsonView(View.Base.class)
    public CollectionEntity saveCollection(@Valid @RequestBody CollectionEntity collection,
            @LoggedInuser CustomUserDetails user) {
        return this.collectionService.saveCollection(collection, user.getUser());
    }

}
