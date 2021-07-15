package com.example.Doc.Dog;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class DogExpectionHandler {

    @ExceptionHandler(value = {DogRequestException.class})
    public ResponseEntity<Object> handleDogRequestException(DogRequestException e){
        // 1. Create payload containing exception details

        HttpStatus badRequest=HttpStatus.BAD_REQUEST;

        DogExpection dogExpection=new DogExpection(
                e.getMessage(), e , badRequest , ZonedDateTime.now(ZoneId.of("Z"))
        );
        // 2. Return reponse entity
        return new ResponseEntity<>(dogExpection , badRequest);
    }


}
