package br.com.lucaskfp.springtodo.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.lucaskfp.springtodo.common.View;
import br.com.lucaskfp.springtodo.user.validations.UniqueEmail;
import lombok.Data;

@Data
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, length = 50)
    @NotBlank(message = "O nome é obrigatório")
    @JsonView(View.Base.class)
    private String name;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Email inválido")
    @UniqueEmail
    @JsonView(View.Base.class)
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 8, message = "A senha precisa ter no mínimo 8 caracteres")
    private String password;

}
