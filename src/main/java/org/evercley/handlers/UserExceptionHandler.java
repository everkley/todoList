package org.evercley.handlers;

import org.evercley.excpetions.UserAlreadyExistsException;
import org.evercley.excpetions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String,Object>> HandlerUserNotFound(UserNotFoundException e){
        Map<String,Object> resultBody = new HashMap<>();
        resultBody.put("timestamp", LocalDateTime.now());
        resultBody.put("status", HttpStatus.NOT_FOUND.value());
        resultBody.put("error", "Usuário não encontrado");
        resultBody.put("message", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resultBody);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<Map<String,Object>> HandlerUserAlreadyExists(UserAlreadyExistsException e){
        Map<String,Object> resultBody = new HashMap<>();
        resultBody.put("timestamp", LocalDateTime.now());
        resultBody.put("status", HttpStatus.CONFLICT.value());
        resultBody.put("error", "Usuário já existe");
        resultBody.put("message", e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(resultBody);
    }


}
