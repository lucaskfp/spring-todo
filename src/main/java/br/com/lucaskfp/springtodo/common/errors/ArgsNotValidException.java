package br.com.lucaskfp.springtodo.common.errors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.MethodArgumentNotValidException;

import lombok.Data;

@Data
public class ArgsNotValidException {

    private final int status = 400;
    private final String error = "Bad Request";
    private final String path;
    private ArrayList<Map<String, String>> errors = new ArrayList<>();

    public ArgsNotValidException(MethodArgumentNotValidException ex, HttpServletRequest r) {
        this.path = r.getServletPath();
        ex.getFieldErrors().forEach(e -> {
            Map<String, String> listErrors = new HashMap<>();
            listErrors.put("message", e.getDefaultMessage());
            listErrors.put("field", e.getField());
            listErrors.put("rejectedValue", (String) e.getRejectedValue());

            this.errors.add(listErrors);
        });

    }
}
