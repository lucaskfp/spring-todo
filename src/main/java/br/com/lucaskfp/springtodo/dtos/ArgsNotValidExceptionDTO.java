package br.com.lucaskfp.springtodo.dtos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import lombok.Data;

@Data
public class ArgsNotValidExceptionDTO {

    private ArrayList<Map<String, String>> errors = new ArrayList<>();

    public ArgsNotValidExceptionDTO(MethodArgumentNotValidException ex) {

        ex.getAllErrors().forEach((e) -> {
            Map<String, String> listErrors = new HashMap<>();
            listErrors.put("message", e.getDefaultMessage());
            listErrors.put("field", ((FieldError) e).getField());

            this.errors.add(listErrors);
        });

    }
}
