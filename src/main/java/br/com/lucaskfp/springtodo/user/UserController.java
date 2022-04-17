package br.com.lucaskfp.springtodo.user;

import java.util.List;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucaskfp.springtodo.common.View;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    @JsonView(View.Base.class)
    @PreAuthorize("@userAuthorizationService.canGet(principal.user.id, #id)")
    public UserEntity getUser(@PathVariable("id") Integer id) {
        return this.userService.getUser(id);
    }

    @GetMapping
    @JsonView(View.Base.class)
    public List<UserEntity> getUsers() {
        return this.userService.getUsers();
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    @JsonView(View.Base.class)
    public UserEntity saveUser(@Valid @RequestBody UserEntity user) {
        return this.userService.saveUser(user);
    }

}
