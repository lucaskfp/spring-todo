package br.com.lucaskfp.springtodo.user;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucaskfp.springtodo.user.dtos.UserDTO;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public UserEntity getUser(@PathVariable("id") Integer id) {
        return this.userService.getUser(id);
    }

    @GetMapping
    public List<UserEntity> getUsers() {
        return this.userService.getUsers();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO saveUser(@Valid @RequestBody UserEntity user) {
        return new UserDTO(this.userService.saveUser(user));
    }

}
