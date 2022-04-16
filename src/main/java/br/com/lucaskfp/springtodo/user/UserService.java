package br.com.lucaskfp.springtodo.user;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.lucaskfp.springtodo.common.errors.NotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserEntity getUser(Integer id) {
        return this.userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("O usuário não existe."));
    }

    public List<UserEntity> getUsers() {
        return this.userRepository.findAll();
    }

    public UserEntity saveUser(UserEntity user) {

        String pwHash = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(pwHash);
        userRepository.save(user);

        return user;

    }

}
