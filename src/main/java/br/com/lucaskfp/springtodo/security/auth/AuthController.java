package br.com.lucaskfp.springtodo.security.auth;

import java.util.Collections;

import javax.security.auth.login.CredentialException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.lucaskfp.springtodo.user.UserEntity;
import br.com.lucaskfp.springtodo.user.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Value("${TOKEN_KEY}")
    private String tokenKey;

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody Credentials credentials) throws CredentialException {

        UserEntity user = userRepository.findByEmail(credentials.getEmail())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED));

        boolean passwordIsValid = passwordEncoder.matches(credentials.getPassword(), user.getPassword());

        if (!passwordIsValid) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        String token = Jwts.builder()
                .claim("email", user.getEmail())
                .claim("id", "" + user.getId())
                .signWith(SignatureAlgorithm.HS512, tokenKey).compact();

        return ResponseEntity.ok(Collections.singletonMap("token", token));
    }

}
