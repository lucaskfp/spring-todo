package br.com.lucaskfp.springtodo.task;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.lucaskfp.springtodo.collection.CollectionEntity;
import br.com.lucaskfp.springtodo.common.View;
import br.com.lucaskfp.springtodo.user.UserEntity;
import lombok.Data;

@Data
@Entity
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(View.Base.class)
    private Integer id;

    @Column(nullable = false)
    @NotBlank(message = "O nome é obrigatório")
    @JsonView(View.Base.class)
    private String name;

    @Column(length = 255)
    @Max(255)
    @JsonView(View.Base.class)
    private String description;

    @JsonView(View.Base.class)
    private Boolean done;

    @ManyToOne
    @JoinColumn(name = "collection_id")
    @JsonView(View.Base.class)
    private CollectionEntity collection;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
}
