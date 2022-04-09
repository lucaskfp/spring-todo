package br.com.lucaskfp.springtodo.services.user;

import java.util.List;

import br.com.lucaskfp.springtodo.models.User;

public interface IUser {
    User getUser(Integer id);

    List<User> getUsers();

    User saveUser(User user);
}
