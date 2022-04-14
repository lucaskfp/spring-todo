package br.com.lucaskfp.springtodo.common.errors;

import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiError {
    private int status;
    private String message;
    private long timestamp;
    private String path;

    public ApiError(HttpStatus status, String message, String path) {
        super();
        this.status = status.value();
        this.message = message;
        this.timestamp = new Date().getTime();
        this.path = path;
    }

    public ApiError(int status, String message, String path) {
        super();
        this.status = status;
        this.message = message;
        this.timestamp = new Date().getTime();
        this.path = path;
    }

}
