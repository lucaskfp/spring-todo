package br.com.lucaskfp.springtodo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, length = 50)
    @NotBlank(message = "O nome é obrigatório")
    private String name;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "A senha é obrigatória")
    private String password;

}
