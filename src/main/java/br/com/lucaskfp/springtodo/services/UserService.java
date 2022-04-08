package br.com.lucaskfp.springtodo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.lucaskfp.springtodo.models.User;
import br.com.lucaskfp.springtodo.repositorys.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getUsers() {
        List<User> list = userRepository.findAll();
        return list;
    }

    public User getUser(Integer id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            return user;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
    }

    public User createUser(User requestBody) {
        User findEmail = userRepository.findByEmailEquals(requestBody.getEmail());

        if (findEmail != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O email informado não está disponível");
        }

        return userRepository.save(requestBody);
    }

}
