package br.com.lucaskfp.springtodo.common.errors;

public class EmailNotAvailableException extends Exception {

    public EmailNotAvailableException() {
        super("Email indisponível");
    }
}
