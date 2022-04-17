package br.com.lucaskfp.springtodo.user;

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
import org.springframework.web.server.ResponseStatusException;

import br.com.lucaskfp.springtodo.common.View;
import br.com.lucaskfp.springtodo.security.CustomUserDetails;
import br.com.lucaskfp.springtodo.security.LoggedInuser;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    @JsonView(View.Base.class)
    // @PreAuthorize("@userAuthorizationService.canGet(principal.id, #id)")
    public UserEntity getUser(@PathVariable("id") Integer id, @LoggedInuser CustomUserDetails userDetails) {

        if (userDetails.getId() != id) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Não autorizado.");
        }

        return this.userService.getUser(id);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    @JsonView(View.Base.class)
    public UserEntity saveUser(@Valid @RequestBody UserEntity user) {
        return this.userService.saveUser(user);
    }

}
