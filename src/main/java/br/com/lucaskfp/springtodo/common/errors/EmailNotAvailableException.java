package br.com.lucaskfp.springtodo.common.errors;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class EmailNotAvailableException extends DataIntegrityViolationException {

    public EmailNotAvailableException() {
        super("Este email já está em uso. Tente outro.");
    }
}
