package br.com.lucaskfp.springtodo.common.errors;

import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DefaultErrorResponse {
    private String status;
    private int code;
    private String message;
    private long timestamp;
    private String path;
    private ArrayList<ValidationErrors> validationErrors;

    public DefaultErrorResponse(HttpStatus status, String message, String path) {
        super();
        this.status = status.name();
        this.code = status.value();
        this.message = message;
        this.timestamp = new Date().getTime();
        this.path = path;
    }

}
