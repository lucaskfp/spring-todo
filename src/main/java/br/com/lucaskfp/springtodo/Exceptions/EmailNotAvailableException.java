package br.com.lucaskfp.springtodo.Exceptions;

public class EmailNotAvailableException extends Exception {

    public EmailNotAvailableException() {
        super("Email indisponível");
    }
}
