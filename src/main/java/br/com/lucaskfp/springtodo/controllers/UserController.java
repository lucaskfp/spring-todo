package br.com.lucaskfp.springtodo.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.lucaskfp.springtodo.Exceptions.EmailNotAvailableException;
import br.com.lucaskfp.springtodo.Exceptions.ResourceNotFoundException;
import br.com.lucaskfp.springtodo.dtos.ArgsNotValidExceptionDTO;
import br.com.lucaskfp.springtodo.dtos.UserDTO;
import br.com.lucaskfp.springtodo.models.User;
import br.com.lucaskfp.springtodo.services.user.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Integer id) {
        try {
            return ResponseEntity.ok().body(userService.getUser(id));
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário não encontrado");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping
    public ResponseEntity<UserDTO> saveUser(@Valid @RequestBody User user) {

        try {
            UserDTO userDTO = new UserDTO(userService.saveUser(user));

            return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
        } catch (EmailNotAvailableException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ArgsNotValidExceptionDTO handleValidationException(MethodArgumentNotValidException ex) {
        return new ArgsNotValidExceptionDTO(ex);
    }

}
