package br.com.lucaskfp.springtodo.user;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import br.com.lucaskfp.springtodo.common.errors.NotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserEntity getUser(Integer id) {
        return this.userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("O usuário não existe."));
    }

    public List<UserEntity> getUsers() {
        return this.userRepository.findAll();
    }

    public UserEntity saveUser(UserEntity user) {

        String pwHash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(pwHash);
        userRepository.save(user);

        return user;

    }

}
