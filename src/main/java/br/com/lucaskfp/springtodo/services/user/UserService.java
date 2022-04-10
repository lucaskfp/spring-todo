package br.com.lucaskfp.springtodo.services.user;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.lucaskfp.springtodo.models.User;
import br.com.lucaskfp.springtodo.repositorys.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService implements IUser {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @Override
    public User getUser(Integer id) {
        log.info("Fetching user by id = {}", id);
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        log.info("Save new user {} to the database", user.getName());
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    // public List<User> getUsers() {
    // List<User> list = userRepository.findAll();
    // return list;
    // }

    // public User getUser(Integer id) {
    // User user = userRepository.findById(id).orElse(null);
    // if (user != null) {
    // return user;
    // }

    // throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não
    // encontrado");
    // }

    // public User createUser(User requestBody) {
    // log.info("Salva o novo usuario {} no banco de dados", requestBody.getName());
    // User findEmail = userRepository.findByEmailEquals(requestBody.getEmail());

    // if (findEmail != null) {
    // throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O email informado
    // não está disponível");
    // }

    // return userRepository.save(requestBody);
    // }

}
