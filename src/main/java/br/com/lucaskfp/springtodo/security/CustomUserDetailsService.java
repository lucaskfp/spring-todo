package br.com.lucaskfp.springtodo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.lucaskfp.springtodo.user.UserEntity;
import br.com.lucaskfp.springtodo.user.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity existsUser = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("O usuário não existe"));

        return new CustomUserDetails(existsUser);
    }

}
