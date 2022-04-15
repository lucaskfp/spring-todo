package br.com.lucaskfp.springtodo.user.dtos;

import br.com.lucaskfp.springtodo.user.UserEntity;
import lombok.Data;

@Data
public class UserDTO {

    private Integer id;
    private String name;
    private String email;

    public UserDTO(UserEntity user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }

}
