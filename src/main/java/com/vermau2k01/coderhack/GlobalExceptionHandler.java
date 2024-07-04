package com.vermau2k01.coderhack;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vermau2k01.coderhack.exception.UserNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String,String>> userNotFoundExceptionHandler(UserNotFoundException e)
    {
        Map<String,String> map = new HashMap<>();
        map.put("message", e.getMessage());
        map.put("success", "false");
        map.put("status", HttpStatus.NOT_FOUND.toString());
        
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }

    @SuppressWarnings("null")
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> invalidMarksExceptionHandler(MethodArgumentNotValidException e)
    {
        Map<String,String> map = new HashMap<>();
        map.put("message", e.getBindingResult().getFieldError().getDefaultMessage());
        map.put("success", "false");
        map.put("status", HttpStatus.BAD_REQUEST.toString());

        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }

}
