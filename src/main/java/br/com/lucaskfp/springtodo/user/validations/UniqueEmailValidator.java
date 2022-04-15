package br.com.lucaskfp.springtodo.user.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.lucaskfp.springtodo.user.UserEntity;
import br.com.lucaskfp.springtodo.user.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final UserRepository userRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        UserEntity inDB = userRepository.findByEmail(value).orElse(null);

        if (inDB == null) {
            return true;
        }

        return false;
    }

}
