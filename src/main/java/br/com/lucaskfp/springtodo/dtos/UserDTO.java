package br.com.lucaskfp.springtodo.dtos;

import br.com.lucaskfp.springtodo.models.User;
import lombok.Data;

@Data
public class UserDTO {

    private Integer id;
    private String name;
    private String email;

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }

}
