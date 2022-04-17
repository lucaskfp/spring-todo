package br.com.lucaskfp.springtodo.collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.lucaskfp.springtodo.common.View;
import br.com.lucaskfp.springtodo.user.UserEntity;
import lombok.Data;

@Data
@Entity
public class CollectionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(View.Base.class)
    private Integer id;

    @Column(nullable = false, length = 50)
    @NotBlank(message = "O nome é obrigatório.")
    @Size(max = 50, message = "Limite de 50 caracteres.")
    @JsonView(View.Base.class)
    private String name;

    @Column(length = 255)
    @Size(max = 255, message = "Limite de 255 caracteres.")
    @JsonView(View.Base.class)
    private String description;

    @Column(length = 30)
    @Size(max = 30, message = "Limite de 30 caracteres.")
    @JsonView(View.Base.class)
    private String accentColor;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

}
