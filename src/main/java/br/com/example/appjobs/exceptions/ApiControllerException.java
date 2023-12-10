package br.com.example.appjobs.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiControllerException {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity exception404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity exceptionNull(){
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity errorNull(){
        return ResponseEntity.status(500).body("Erro ao executar a busca");
    }


}
