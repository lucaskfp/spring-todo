package br.com.lucaskfp.springtodo.services.user;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import br.com.lucaskfp.springtodo.Exceptions.EmailNotAvailableException;
import br.com.lucaskfp.springtodo.Exceptions.ResourceNotFoundException;
import br.com.lucaskfp.springtodo.models.User;
import br.com.lucaskfp.springtodo.repositorys.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements IUser {

    private final UserRepository userRepository;

    @Override
    public User getUser(Integer id) throws ResourceNotFoundException {
        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            throw new ResourceNotFoundException("Usuário não encontrado");
        }

        return user;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) throws EmailNotAvailableException {

        User findEmail = userRepository.findByEmailEquals(user.getEmail()).orElse(null);

        if (findEmail != null) {
            throw new EmailNotAvailableException();
        }

        String pwHash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(pwHash);
        userRepository.save(user);

        return user;

    }

}
