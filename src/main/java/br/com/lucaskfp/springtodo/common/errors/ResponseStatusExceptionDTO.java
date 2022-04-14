package br.com.lucaskfp.springtodo.common.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import lombok.Data;

@Data
public class ResponseStatusExceptionDTO extends ResponseStatusException {

    private String teste = "teste";

    public ResponseStatusExceptionDTO(HttpStatus status, String reason) {
        super(status, reason);
    }

}
