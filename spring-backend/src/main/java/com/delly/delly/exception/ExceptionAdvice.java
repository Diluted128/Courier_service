package com.delly.delly.exception;

import com.delly.delly.exception.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(EntityAlreadyExistException.class)
    public ResponseEntity<String> userAlreadyExistHandler(EntityAlreadyExistException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ResponseBody
    @ExceptionHandler(EntityLimitException.class)
    public ResponseEntity<String> cardLimitHandler(EntityLimitException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ResponseBody
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> cardNotFoundHandler(EntityNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ResponseBody
    @ExceptionHandler(EntityStatusException.class)
    public ResponseEntity<String> dOrderHasBeenAlreadyDeliveredHandler(EntityStatusException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
