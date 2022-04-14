package br.com.lucaskfp.springtodo.Exceptions;

public class ResourceNotFoundException extends Exception {

    public ResourceNotFoundException(String reason) {
        super(reason);
    }

}
