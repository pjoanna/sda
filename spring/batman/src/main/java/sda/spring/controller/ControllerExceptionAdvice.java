package sda.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import sda.spring.model.BatmanException;

@ControllerAdvice
public class ControllerExceptionAdvice {
    @ExceptionHandler
    public ResponseEntity<String> handleBatman(BatmanException e){
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
