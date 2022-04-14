package br.com.lucaskfp.springtodo.services.user;

import java.util.List;

import br.com.lucaskfp.springtodo.Exceptions.EmailNotAvailableException;
import br.com.lucaskfp.springtodo.Exceptions.ResourceNotFoundException;
import br.com.lucaskfp.springtodo.models.User;

public interface IUser {
    User getUser(Integer id) throws ResourceNotFoundException;

    List<User> getUsers();

    User saveUser(User user) throws EmailNotAvailableException;
}
