package com.example.WebProject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//Korreter Fehlercode auf dem Server
@RestControllerAdvice
public class EnemyNotFoundAdvice {
    @ExceptionHandler(EnemyNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String enemyNotFoundHandler(EnemyNotFoundException ex) {
        return ex.getMessage();
    }
}
