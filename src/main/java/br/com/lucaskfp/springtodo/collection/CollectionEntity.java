package br.com.lucaskfp.springtodo.collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

import br.com.lucaskfp.springtodo.user.UserEntity;
import lombok.Data;

@Data
@Entity
public class CollectionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, length = 50, unique = true)
    @NotBlank(message = "O nome é obrigatório.")
    @Max(value = 50, message = "Limite de 50 caracteres.")
    private String name;

    @Column(length = 255)
    @Max(value = 255)
    private String description;

    @Column(length = 30)
    @Max(value = 30)
    private String accentColor;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @NotBlank
    private UserEntity user;

}
